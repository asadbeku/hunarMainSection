package com.example.mainapphunar.adapter.category

import androidx.recyclerview.widget.DiffUtil
import com.example.mainapphunar.types.CategoryType
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CategoryAdapter(private val onItemClicked: (position: Int)-> Unit): AsyncListDifferDelegationAdapter<CategoryType>(
    ProductDiffUtilCallBack()
) {

    init {
        delegatesManager.addDelegate(CategoryAdapterDelegate(onItemClicked))
    }

    class ProductDiffUtilCallBack: DiffUtil.ItemCallback<CategoryType>(){
        override fun areItemsTheSame(oldItem: CategoryType, newItem: CategoryType): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryType, newItem: CategoryType): Boolean {
            return oldItem==newItem
        }

    }

}