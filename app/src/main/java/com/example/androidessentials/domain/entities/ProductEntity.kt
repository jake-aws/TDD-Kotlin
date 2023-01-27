package com.example.androidessentials.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_items")
data class ProductEntity(
    @ColumnInfo val brand: String,
    @ColumnInfo val category: String,
    @ColumnInfo val description: String,
    @ColumnInfo val price: Int,
    @ColumnInfo val discountPercentage: Double,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)

fun ProductEntity.toProduct(): Product {
    return Product(
        brand = brand,
        category = category,
        description = description,
        price = price,
        discountPercentage = discountPercentage,
        id = id
    )
}