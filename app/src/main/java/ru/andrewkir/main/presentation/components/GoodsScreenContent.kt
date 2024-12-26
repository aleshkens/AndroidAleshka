package ru.andrewkir.main.presentation.components

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.andrewkir.main.presentation.contract.GoodsEvent
import ru.andrewkir.main.presentation.contract.GoodsState

@Composable
fun GoodsScreenContent(
  uiState: GoodsState,
  onEvent: (GoodsEvent) -> Unit,
)


{
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      TextField(value = uiState.goodsName,
        onValueChange = { changedValue -> onEvent(GoodsEvent.UpdateGoodsNameField(changedValue)) },
        label = { Text("Название") })

    }
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      TextField(value = uiState.goodsPrice,
        onValueChange = { changedValue -> onEvent(GoodsEvent.UpdateGoodsPriceField(changedValue)) },
        label = { Text("Цена") })

    }
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      TextField(value = uiState.goodsCondition,
        onValueChange = { changedValue -> onEvent(GoodsEvent.UpdateGoodsConditionField(changedValue)) },
        label = { Text("Состояние объекта (1 - 5)") })

    }
    Column(
      modifier = Modifier.fillMaxWidth(),
    ) {
      TextField(value = uiState.goodsImageURL,
        onValueChange = { changedValue -> onEvent(GoodsEvent.UpdateGoodsImageURLField(changedValue)) },
        label = { Text("Ссылка на фото") })
    }
    Button(
      modifier = Modifier.padding(start = 14.dp),
      onClick = {
        onEvent(GoodsEvent.AddButtonClicked)
      }) {
      Text(text = "Добавить товар")
    }
  }
    LazyColumn {
      uiState.goods.forEach { item ->
          item {
            GoodsCard(
              Modifier.padding(12.dp),
              item
            )
          }
      }
    }
  }