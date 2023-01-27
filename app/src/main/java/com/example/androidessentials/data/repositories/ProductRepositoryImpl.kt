package com.example.androidessentials.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.androidessentials.common.APIResponse
import com.example.androidessentials.data.local.dao.ProductDAO
import com.example.androidessentials.data.remote.api.ProductAPI
import com.example.androidessentials.domain.entities.ProductEntity
import com.example.androidessentials.domain.entities.toProductEntity
import com.example.androidessentials.domain.repositories.ProductRepository
import retrofit2.Response
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productAPI: ProductAPI,
    private val productDAO: ProductDAO
) : ProductRepository {
    override suspend fun insertProduct(productEntity: ProductEntity) {
        productDAO.insertProduct(productEntity)
    }

    override suspend fun deleteProduct(productEntity: ProductEntity) {
        productDAO.deleteProduct(productEntity)
    }

    override suspend fun updateProduct(productEntity: ProductEntity) {
        productDAO.updateProduct(productEntity)
    }

    override suspend fun getAllProduct(): LiveData<List<ProductEntity>> {
        return productDAO.getAllProduct()
    }

    override suspend fun getProductById(productId: Int): LiveData<ProductEntity> {
        val response = safeAPICall { productAPI.getProduct(productId) }
        if (response.isSuccessful) {
            val product = response.body.toProductEntity()
            Log.d("RESPONSE", product.brand)
            productDAO.insertProduct(product)
        }
        return productDAO.getProductById(productId)
    }

    private inline fun <T> safeAPICall(apiCall: () -> Response<T>): APIResponse<T> {
        return try {
            APIResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            APIResponse.failure(e)
        }
    }
}