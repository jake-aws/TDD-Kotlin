package com.example.androidessentials.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.androidessentials.domain.entities.ProductEntity

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity)

    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)

    @Update
    suspend fun updateProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product_items")
    fun getAllProduct(): LiveData<List<ProductEntity>>

    @Query("SELECT * FROM product_items WHERE product_items.id = :productId")
    fun getProductById(productId: Int): LiveData<ProductEntity>
}