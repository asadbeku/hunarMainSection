package com.example.mainapphunar.products.exclusive.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mainapphunar.adapter.product.ProductAdapter
import com.example.mainapphunar.R
import com.example.mainapphunar.databinding.FragmentBrandProductsBinding
import com.example.mainapphunar.databinding.FragmentExclusiveProductsBinding
import com.example.mainapphunar.products.view_model.ExclusiveViewModel

class ExclusiveProductsFragment : Fragment(R.layout.fragment_exclusive_products) {

    private val mainAppLivedata: ExclusiveViewModel by viewModels()
    private var productAdapter: ProductAdapter? = null

    private var _binding: FragmentExclusiveProductsBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExclusiveProductsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        observeProducts()
    }

    private fun initList() {
        val gridLayoutManager = GridLayoutManager(requireContext(), 2).apply {
            orientation = GridLayoutManager.VERTICAL
        }

        mainAppLivedata.getProducts()

        productAdapter = ProductAdapter { id ->
            Toast.makeText(requireContext(), "Id: $id", Toast.LENGTH_SHORT).show()
        }

        with(binding.recycler) {
            adapter = productAdapter
            layoutManager = gridLayoutManager
            setHasFixedSize(true)
        }
    }

    private fun observeProducts(){
        mainAppLivedata.products.observe(viewLifecycleOwner){list->
            productAdapter?.items = list
        }
    }

}