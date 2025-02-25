package ru.andrewkir.main.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.andrewkir.main.presentation.components.GoodsScreenContent
import ru.andrewkir.main.presentation.viewmodels.GoodsViewModel

@Composable
fun GoodsScreen() {

  val viewModel = viewModel<GoodsViewModel>()

  val state by viewModel.state.collectAsState()

  GoodsScreenContent(
    uiState = state,
    onEvent = viewModel::handleEvent
  )
}