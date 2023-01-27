package com.example.androidessentials.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidessentials.data.local.dao.ProductDAO
import com.example.androidessentials.domain.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDB:RoomDatabase() {
    abstract fun productDao(): ProductDAO
}