package com.example.androidessentials.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.androidessentials.domain.entities.Product

@Dao
interface ProductDAO {
    @Insert
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Query("SELECT * FROM product_items")
    fun getAllProduct(): LiveData<List<Product>>

    @Query("SELECT * FROM product_items WHERE product_items.id = :productId")
    fun getProductById(productId: Int): LiveData<Product>
}