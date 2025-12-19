package com.example.questapi_050.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_050.modeldata.DataSiswa
import com.example.questapi_050.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface StatusUiSiswa{
    data class Succes(val siswa: List<DataSiswa> = listOf()): StatusUiSiswa
    object Loading: StatusUiSiswa
    object Error: StatusUiSiswa
}

class HomeViewModel (private val repositoryDataSiswa: RepositoryDataSiswa):
    ViewModel() {
        var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
            private set

    init {
        loadSiswa()
    }
    fun loadSiswa(){
        viewModelScope.launch {
            listSiswa = StatusUiSiswa.Loading
            listSiswa = try {
                StatusUiSiswa.Succes(repositoryDataSiswa.getAllSiswa())
            }catch (e: IOException){
                StatusUiSiswa.Error
            }catch (e: HttpException){
                StatusUiSiswa.Error
            }
        }
    }
    }