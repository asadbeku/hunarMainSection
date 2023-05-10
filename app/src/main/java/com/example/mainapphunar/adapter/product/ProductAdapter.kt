package com.example.mainapphunar.adapter.product

import androidx.recyclerview.widget.DiffUtil
import com.example.mainapphunar.types.ProductType
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ProductAdapter(private val onItemClicked: (position: Int)-> Unit): AsyncListDifferDelegationAdapter<ProductType>(
    ProductDiffUtilCallBack()
) {

    init {
        delegatesManager.addDelegate(ProductAdapterDelegate(onItemClicked))
    }



    class ProductDiffUtilCallBack: DiffUtil.ItemCallback<ProductType>(){
        override fun areItemsTheSame(oldItem: ProductType, newItem: ProductType): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductType, newItem: ProductType): Boolean {
            return oldItem==newItem
        }

    }

}