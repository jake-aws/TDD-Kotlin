package com.example.androidessentials.data.local.repositories

import androidx.lifecycle.LiveData
import com.example.androidessentials.data.local.dao.ProductDAO
import com.example.androidessentials.domain.entities.Product
import com.example.androidessentials.domain.repositories.ProductRepository

class ProductRepositoryImpl(private val productDAO: ProductDAO) : ProductRepository {
    override suspend fun insertProduct(product: Product) {
        productDAO.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        productDAO.deleteProduct(product)
    }

    override suspend fun updateProduct(product: Product) {
        productDAO.updateProduct(product)
    }

    override fun getAllProduct(): LiveData<List<Product>> {
        return productDAO.getAllProduct()
    }

    override fun getProductById(productId: Int): LiveData<Product> {
        return productDAO.getProductById(productId)
    }
}