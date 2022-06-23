package com.example.mvvm_home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_home.api.model.Book
import com.example.mvvm_home.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = Repository()


    val book: MutableLiveData<Book> = MutableLiveData()

    fun getBook(name: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getBooks(name).let {
                book.postValue(it.body())
            }
        }

    }
}