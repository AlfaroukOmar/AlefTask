package com.alef.domain.usecases

import com.alef.domain.entities.ProductEntity
import com.alef.domain.repositories.FoodRepository
import javax.inject.Inject

class ChangeFavouriteStatesUseCase @Inject constructor(private val repository: FoodRepository) {
    suspend operator fun invoke(prodId: ProductEntity, isFav: Boolean) =
        repository.changeFavouriteStates(prodId, isFav)
}