package com.example.androidessentials.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val id: Int,
):Parcelable