package com.example.androidessentials.data.local.database

import androidx.room.Database
import com.example.androidessentials.data.local.dao.ProductDAO

@Database(entities = [ProductDB::class], version = 1)
abstract class ProductDB {
    abstract fun productDao(): ProductDAO
}