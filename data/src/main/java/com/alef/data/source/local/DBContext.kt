package com.alef.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProductDBEntity::class], version = 1, exportSchema = false)
abstract class DBContext : RoomDatabase() {
    abstract fun FoodDAO(): FoodDAO
}