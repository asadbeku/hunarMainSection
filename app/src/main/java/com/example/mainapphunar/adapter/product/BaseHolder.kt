package com.example.mainapphunar.adapter.product

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mainapphunar.R
import com.example.mainapphunar.databinding.ItemProductBinding

abstract class BaseHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    init {
        view.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(name: String, price: String, image: String){
        binding.productName.text = name
        binding.productPrice.text = price

        Glide.with(itemView)
            .load(image)
            .placeholder(R.drawable.product_500px)
            .into(binding.productImage)
    }
}