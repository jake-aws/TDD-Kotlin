package com.example.androidessentials.di

import android.content.Context
import androidx.room.Room
import com.example.androidessentials.data.local.database.ProductDB
import com.example.androidessentials.data.remote.api.ProductAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import  retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ProductDB::class.java, "product_database").build()

    @Provides
    @Singleton
    fun provideDAO(db: ProductDB) = db.productDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
        .addConverterFactory(MoshiConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }



}