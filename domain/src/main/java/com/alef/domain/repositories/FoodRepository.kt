package com.alef.domain.repositories

import com.alef.domain.entities.ProductEntity

interface FoodRepository {
    suspend fun getFoodList(): List<ProductEntity>
    suspend fun getFavouriteList(): List<ProductEntity>
    suspend fun changeFavouriteStates(prodId: Int, isFav: Boolean): Boolean
    suspend fun addFavourite(productEntity: ProductEntity): Boolean
    suspend fun removeFavourite(productEntity: ProductEntity): Boolean
}