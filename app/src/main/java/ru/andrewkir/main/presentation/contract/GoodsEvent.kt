package ru.andrewkir.main.presentation.contract

sealed class GoodsEvent {

  data class UpdateGoodsNameField(val text: String): GoodsEvent()
  data class UpdateGoodsPriceField(val text: String): GoodsEvent()
  data class UpdateGoodsConditionField(val text: String): GoodsEvent()
  data class UpdateGoodsImageURLField(val url: String): GoodsEvent()
  data object AddButtonClicked: GoodsEvent()
}