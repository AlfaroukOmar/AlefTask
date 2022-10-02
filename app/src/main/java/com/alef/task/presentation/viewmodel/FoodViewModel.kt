package com.alef.task.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.alef.domain.entities.ProductEntity
import com.alef.domain.usecases.ChangeFavouriteStatesUseCase
import com.alef.domain.usecases.GetFavoritesListUseCase
import com.alef.domain.usecases.GetFoodListUseCase
import com.alef.task.common.BaseViewModel
import com.alef.task.common.Resource
import com.alef.task.di.qualifier.IoScheduler
import com.alef.task.di.qualifier.MainScheduler
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class FoodViewModel @Inject constructor(
    private val FoodList: GetFoodListUseCase,
    private val FavoritesList: GetFavoritesListUseCase,
    private val FavouriteStates: ChangeFavouriteStatesUseCase,
    @IoScheduler
    private val ioScheduler: CoroutineDispatcher,
    @MainScheduler
    private val mainScheduler: CoroutineDispatcher,
) : BaseViewModel() {

    val FoodListState by lazy { MutableLiveData<Resource<List<ProductEntity>>>() }

    private var job: Job? = null

    fun getFoodList() {

        FoodListState.value = Resource.loading()
        job = CoroutineScope(ioScheduler).launch {
            try {

                val response = FoodList.invoke()
                CoroutineScope(mainScheduler).launch {
                    if (response.data == null)
                        FoodListState.value = Resource.error(null, response.error)
                    else
                        FoodListState.value = Resource.success(response.data!!)

                }

            } catch (e: Exception) {
                e.printStackTrace()
                CoroutineScope(mainScheduler).launch {

                    if (e !is CancellationException) {
                        FoodListState.value = Resource.error(null, "")
                    }
                }
            }

        }

    }

    fun getFavoritesList() {

        FoodListState.value = Resource.loading()
        job = CoroutineScope(ioScheduler).launch {
            try {
                val response = FavoritesList.invoke()
                CoroutineScope(mainScheduler).launch {
                    FoodListState.value = Resource.success(response.last())
                }

            } catch (e: Exception) {
                e.printStackTrace()
                CoroutineScope(mainScheduler).launch {

                    if (e !is CancellationException) {
                        FoodListState.value = Resource.error(null, "")
                    }
                }
            }
        }

    }


    fun ChangeFavouriteStates(productEntity: ProductEntity, isFav: Boolean) {
        FoodListState.value = Resource.loading()
        job = CoroutineScope(ioScheduler).launch {
            try {

                val response = FavouriteStates.invoke(productEntity, isFav)
                CoroutineScope(mainScheduler).launch {

                }

            } catch (e: Exception) {
                e.printStackTrace()
                CoroutineScope(mainScheduler).launch {

                    if (e !is CancellationException) {
                        FoodListState.value = Resource.error(null, "")
                    }
                }
            }

        }

    }
}