package com.example.androidessentials.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_items")
data class Product(
    @ColumnInfo val brand: String,
    @ColumnInfo val category: String,
    @ColumnInfo val description: String,
    @ColumnInfo val discountPercentage: Double,
    @PrimaryKey(autoGenerate = true) val id: Int,
)