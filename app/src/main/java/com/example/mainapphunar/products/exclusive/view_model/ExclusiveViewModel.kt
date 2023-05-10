package com.example.mainapphunar.products.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainapphunar.types.ProductType

class ExclusiveViewModel : ViewModel() {
    private val repository = Repository()

    private var productList = MutableLiveData<List<ProductType>>()
    val products: LiveData<List<ProductType>>
        get() = productList

    fun getProducts() {
        val list = repository.productList
        var filteredList: MutableList<ProductType> = mutableListOf()
        for(item in list){
            if (item.e_status){
                filteredList.add(item)
            }
        }

        productList.postValue(filteredList)
    }
}