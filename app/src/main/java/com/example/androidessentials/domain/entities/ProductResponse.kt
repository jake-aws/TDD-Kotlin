package com.example.androidessentials.domain.entities

data class ProductResponse(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)
fun ProductResponse.toProduct(): Product {
    return Product(
        brand = this.brand,
        category = this.category,
        price = this.price,
        description = this.description,
        discountPercentage = this.discountPercentage
    )
}