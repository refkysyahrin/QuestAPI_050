package com.example.questapi_050.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questapi_050.viewmodel.EditViewModel
import com.example.questapi_050.viewmodel.provider.PenyediaViewModel
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {

}