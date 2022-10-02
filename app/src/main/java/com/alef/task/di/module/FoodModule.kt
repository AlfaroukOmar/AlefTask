package com.alef.task.di.module

import com.alef.data.repositories.FoodRepositoryImpl
import com.alef.domain.repositories.FoodRepository
import dagger.Module

@Module
interface FoodModule {
    @dagger.Binds
    fun bindFoodRepository(
        repo: FoodRepositoryImpl
    ): FoodRepository
}