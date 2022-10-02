package com.alef.data.repositories

import com.alef.data.Mapper.toEntity
import com.alef.data.source.local.DBContext
import com.alef.data.source.local.toDb
import com.alef.data.source.local.toEntity
import com.alef.data.source.remote.ApiService
import com.alef.domain.entities.DefaultProduct
import com.alef.domain.entities.ProductEntity
import com.alef.domain.entities.Status
import com.alef.domain.repositories.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FoodRepositoryImpl(
    @Inject private val apiService: ApiService,
    @Inject val dbHelper: DBContext,
) : FoodRepository {
    override suspend fun getFoodList(): Status<List<ProductEntity>> {
        val response = apiService.getFoodList()

        val list = dbHelper.FoodDAO().getIds()

        if (response.isSuccessed == false) {
            return Status(null, response.error ?: "something wrong happen")
        } else {

            val res = response.data?.map { it?.toEntity() ?: DefaultProduct }

            res?.forEach {
                it.isFav = list.contains(it.Id)
            }

            return Status(res, "")
        }
    }

    override suspend fun getFavouriteList(): Flow<List<ProductEntity>> {
        return dbHelper.FoodDAO().getAll().map { it ->
            it.map {
                it.toEntity()
            }
        }
    }

    override suspend fun changeFavouriteStates(prodId: ProductEntity, isFav: Boolean): Boolean {
        if (isFav) {
            addFavourite(prodId)
        } else
            removeFavourite(prodId)

        return true
    }

    override suspend fun addFavourite(productEntity: ProductEntity): Boolean {
        dbHelper.FoodDAO().insert(productEntity.toDb())
        return true
    }

    override suspend fun removeFavourite(productEntity: ProductEntity): Boolean {
        dbHelper.FoodDAO().delete(productEntity.toDb())
        return true
    }
}