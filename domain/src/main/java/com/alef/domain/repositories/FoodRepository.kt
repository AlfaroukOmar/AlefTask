package com.alef.domain.repositories

import com.alef.domain.entities.ProductEntity
import com.alef.domain.entities.Status
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun getFoodList(): Status<List<ProductEntity>>
    suspend fun getFavouriteList(): Flow<List<ProductEntity>>
    suspend fun changeFavouriteStates(prodId: ProductEntity, isFav: Boolean): Boolean
    suspend fun addFavourite(productEntity: ProductEntity): Boolean
    suspend fun removeFavourite(productEntity: ProductEntity): Boolean
}