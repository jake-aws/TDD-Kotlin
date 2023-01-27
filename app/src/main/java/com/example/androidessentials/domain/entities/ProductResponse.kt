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
fun ProductResponse.toProductEntity(): ProductEntity {
    return ProductEntity(
        brand = brand,
        category = category,
        price = price,
        description = description,
        discountPercentage = discountPercentage
    )
}