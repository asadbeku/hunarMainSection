package com.example.mainapphunar.adapter.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.mainapphunar.types.ProductType
import com.example.mainapphunar.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ProductAdapterDelegate(private val onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<ProductType, ProductType, ProductAdapterDelegate.ProductHolder>() {

    override fun isForViewType(
        item: ProductType,
        items: MutableList<ProductType>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): ProductHolder {
        return ProductHolder(
            parent.inflate(R.layout.item_product), onItemClicked
        )
    }

    override fun onBindViewHolder(
        item: ProductType,
        holder: ProductHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class ProductHolder(view: View, onItemClicked: (position: Int) -> Unit) :
        BaseHolder(view, onItemClicked) {
        fun bind(product: ProductType) {
            bind(product.name_uz, product.price, product.main_image)
        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}