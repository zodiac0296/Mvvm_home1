package com.example.mvvm_home.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_home.adapter.BookAdapter
import com.example.mvvm_home.databinding.ActivityMainBinding
import com.example.mvvm_home.databinding.LayoutItemBinding
import com.example.mvvm_home.util.Status

class MainActivity : AppCompatActivity(),BookAdapter.OnClick {

    lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { MainViewModel() }

    private val adapter by lazy { BookAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            getAllBooks()
            getAllBooksResource()
        }
    }
    private fun getAllBooksResource(){
        viewModel.getBookResource(binding.edText.text.toString())
        viewModel.booksResource.observe(this){
            when(it.status){
                Status.LOADIND -> binding.progressBar.visibility = View.VISIBLE
                Status.SUCCESS -> {
                    adapter.setList(it.data?.items!!)
                    binding.recyclerView.adapter = adapter
                    binding.recyclerView.layoutManager = LinearLayoutManager(this)
                    binding.progressBar.visibility = View.GONE
                }
                Status.ERROR -> {
                    Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun getAllBooks(){
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getBook(binding.edText.text.toString())
        viewModel.book.observe(this){
            adapter.setList(it.items)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.progressBar.visibility = View.GONE

        }
    }

    override fun onClicked(holder: BookAdapter.ViewHolder, position: Int) {
        (holder.binding).let {
            it.image.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(adapter.getItem(position)?.accessInfo?.webReaderLink)
                startActivity(intent)
            }
        }
    }


}