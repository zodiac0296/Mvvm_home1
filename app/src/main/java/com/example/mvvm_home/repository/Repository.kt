package com.example.mvvm_home.repository

import com.example.mvvm_home.api.RetrofitObject
import com.example.mvvm_home.api.model.Book
import retrofit2.Response

class Repository {
    private val api = RetrofitObject.api

    suspend fun getBooks(name: String): Response<Book>{
        return api.getBook(name)
    }
}