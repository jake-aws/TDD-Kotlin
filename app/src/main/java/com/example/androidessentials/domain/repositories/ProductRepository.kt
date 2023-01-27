package com.example.androidessentials.domain.repositories

import androidx.lifecycle.LiveData
import com.example.androidessentials.domain.entities.ProductEntity

interface ProductRepository {

    suspend fun insertProduct(productEntity: ProductEntity)

    suspend fun deleteProduct(productEntity: ProductEntity)

    suspend fun updateProduct(productEntity: ProductEntity)

    suspend fun getAllProduct(): LiveData<List<ProductEntity>>

    suspend fun getProductById(productId: Int): LiveData<ProductEntity>

}