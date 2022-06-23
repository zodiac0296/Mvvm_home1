package com.example.mvvm_home.api.model

data class Book(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)