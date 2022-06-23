package com.example.mvvm_home.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/volumes")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
        val api: ApiServies by lazy {
            retrofit.create(ApiServies::class.java)

    }
}