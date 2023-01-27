package com.example.androidessentials.data.remote.api

import com.example.androidessentials.common.APIResponse
import com.example.androidessentials.domain.entities.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{productID}")
    suspend fun getProduct(@Path("productID") productID: Int): Response<ProductResponse>

}