package com.alef.domain.entities


data class ProductEntity(
    val Id: Int,
    val Name: String,
    val Description: String,
    val prepare_time: Int,
    val avg_rate: Double,
    val ImagePath: String,
    val price: Double,
    var isFav: Boolean
)


val DefaultProduct = ProductEntity(0, "", "", 0, 0.0, "", 0.0, false)