package com.alef.domain.entities

data class ProductEntity(
    val Id: Int,
    val Name: String,
    val Description: String,
    val prepare_time: Int,
    val avg_rate: Double,
    val main_image: String,
    val price: Double
)