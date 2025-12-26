package com.example.questapi_050.viewmodel

import com.example.questapi_050.modeldata.DataSiswa

sealed interface StatusUIDetail{
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}


