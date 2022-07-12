package com.example.mvvm_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_home.R
import com.example.mvvm_home.api.model.Item
import com.example.mvvm_home.databinding.LayoutItemBinding
import com.example.mvvm_home.ui.MainActivity
import com.squareup.picasso.Picasso

class BookAdapter(
    private val listener: MainActivity
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private var items: List<Item> = listOf()

    inner class ViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.ViewHolder {

        val binding: LayoutItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) {
        listener.onClicked(holder, position)
        val current = items[position]
        holder.binding.let {
            it.title.text = current.volumeInfo.title
            it.category.text = current.volumeInfo.printType
            it.author.text = current.volumeInfo.language
            it.desc.text = current.volumeInfo.publishedDate
            if (current.volumeInfo.imageLinks.thumbnail != null)
                Picasso.get().load(current.volumeInfo.imageLinks.thumbnail).into(it.image)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnClick {
        fun onClicked(holder: ViewHolder, position: Int)

    }

    fun getItem(position: Int): Item? {
        return if (position != null) {
            items[position]
        } else
            null
    }

    fun setList(items: List<Item>) {
        this.items = items
    }
}
