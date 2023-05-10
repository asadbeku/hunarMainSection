package com.example.mainapphunar.adapter.category

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainapphunar.R
import com.example.mainapphunar.databinding.ActivityTabsBinding
import com.example.mainapphunar.databinding.ItemCategoryBinding
import com.example.mainapphunar.databinding.ItemProductBinding

abstract class BaseHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCategoryBinding.bind(view)

    init {
        view.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(image: String, name: String){
        binding.categoryNameTextView.text = name

        Glide.with(itemView)
            .load(image)
            .placeholder(R.drawable.product_500px)
            .into(binding.categoryImage)
    }
}