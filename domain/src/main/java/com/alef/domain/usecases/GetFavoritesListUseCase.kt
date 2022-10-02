package com.alef.domain.usecases

import com.alef.domain.repositories.FoodRepository
import javax.inject.Inject

class GetFavoritesListUseCase @Inject constructor(private val repository: FoodRepository) {
    suspend operator fun invoke() =
        repository.getFavouriteList()
}