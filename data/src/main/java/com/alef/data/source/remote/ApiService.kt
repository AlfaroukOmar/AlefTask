package com.alef.data.source.remote

import com.alef.data.source.remote.models.FoodResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("client/products/producttitle")
    suspend fun getFoodList(
        @Query("lat") lat: Double = 30.063903808594,
        @Query("lng") lng: Double = 31.326583983165,
        @Query("page") page: Int = 1,
    ): FoodResponse
}