package com.example.mainapphunar.tab_layout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mainapphunar.products.exclusive.ui.ExclusiveProductsFragment
import com.example.mainapphunar.products.Brands.ui.BrandProductsFragment

class FragmentPageAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BrandProductsFragment()
            1 -> ExclusiveProductsFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}