package com.alef.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodDAO {
    @Query("SELECT * FROM ProductDBEntity")
    fun getAll(): Flow<List<ProductDBEntity>>

    @Query("SELECT Id FROM ProductDBEntity")
    fun getIds(): List<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(product: ProductDBEntity)

    @Delete
    fun delete(product: ProductDBEntity)
}