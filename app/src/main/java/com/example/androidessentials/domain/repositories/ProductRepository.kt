package com.example.androidessentials.domain.repositories

import androidx.lifecycle.LiveData
import com.example.androidessentials.domain.entities.Product

interface ProductRepository {

    suspend fun insertProduct(product: Product)

    suspend fun deleteProduct(product: Product)

    suspend fun updateProduct(product: Product)

    fun getAllProduct(): LiveData<List<Product>>

    fun getProductById(productId: Int): LiveData<Product>
}