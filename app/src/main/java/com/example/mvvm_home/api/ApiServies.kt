package com.example.mvvm_home.api

import com.example.mvvm_home.api.model.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServies {
    @GET("")
    suspend fun getBook(
        @Query("q") book: String
    ): Response<Book>
}