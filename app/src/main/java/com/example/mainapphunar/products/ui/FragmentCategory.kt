package com.example.mainapphunar.products.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.mainapphunar.R
import com.example.mainapphunar.databinding.ItemCategoryBinding
import com.example.mainapphunar.tab_layout.withArguments

class FragmentCategory: Fragment(R.layout.item_category) {

    private lateinit var binding: ItemCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.categoryNameTextView.setText(requireArguments().getInt(KEY_TEXT))
        binding.categoryImage.setImageResource(requireArguments().getInt(KEY_IMAGE))
    }

    companion object {

        private const val KEY_TEXT = "text"
        private const val KEY_IMAGE = "image"

        fun newInstance(
            @StringRes textRes: Int,
            @DrawableRes drawableRes: Int
        ): TabsFragment {
            return TabsFragment().withArguments {
                putInt(KEY_TEXT, textRes)
                putInt(KEY_IMAGE, drawableRes)
            }
        }
    }

}