package ru.andrewkir.main.presentation.contract

import ru.andrewkir.main.data.models.GoodsItemModel

data class GoodsState(
  val goodsName: String = "",
  val goodsPrice: String = "",
  val goodsCondition: String = "",
  val goodsImageURL: String = "",
  val goods: List<GoodsItemModel> = emptyList())