package ru.andrewkir.main.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.main.data.models.GoodsItemModel
import ru.andrewkir.main.presentation.contract.GoodsEvent
import ru.andrewkir.main.presentation.contract.GoodsEvent.UpdateGoodsNameField
import ru.andrewkir.main.presentation.contract.GoodsEvent.UpdateGoodsPriceField
import ru.andrewkir.main.presentation.contract.GoodsEvent.UpdateGoodsConditionField
import ru.andrewkir.main.presentation.contract.GoodsEvent.UpdateGoodsImageURLField
import ru.andrewkir.main.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is UpdateGoodsNameField -> {
        state.value = state.value.copy(goodsName = event.text)
      }
      is UpdateGoodsPriceField -> {
        state.value = state.value.copy(goodsPrice = event.text)
      }
      is UpdateGoodsConditionField -> {
        state.value = state.value.copy(goodsCondition = event.text)
      }
      is UpdateGoodsImageURLField -> {
        state.value = state.value.copy(goodsImageURL = event.url)
      }

      GoodsEvent.AddButtonClicked -> {
        state.value = state.value.copy(
          goods = state.value.goods + listOf(
            GoodsItemModel(
              name = state.value.goodsName,
              price = state.value.goodsPrice.toInt(),
              condition = state.value.goodsCondition.toInt(),
              imageURL = state.value.goodsImageURL,
              )
          ),
          goodsName = "",
          goodsPrice = "",
          goodsCondition = "",
          goodsImageURL = "",
        )
      }

      GoodsEvent.AddButtonClicked -> TODO()
    }
  }
}