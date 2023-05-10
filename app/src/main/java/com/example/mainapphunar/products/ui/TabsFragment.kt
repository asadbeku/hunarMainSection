package com.example.mainapphunar.products.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mainapphunar.R
import com.example.mainapphunar.adapter.slider.ImageSliderAdapter
import com.example.mainapphunar.databinding.ActivityTabsBinding
import com.example.mainapphunar.tab_layout.FragmentPageAdapter
import com.example.mainapphunar.types.CategoryResList
import com.google.android.material.tabs.TabLayoutMediator
import com.smarteist.autoimageslider.SliderView

class TabsFragment : Fragment(R.layout.activity_tabs) {

    private var _binding: ActivityTabsBinding? = null
    private val binding get() = _binding!!
    lateinit var sliderView: SliderView
    private val screens: List<CategoryResList> = listOf(
        CategoryResList(
            "First slider",
            "https://edumonitoring.uz/media/hunar_type/Milliy%20o'yinchoqlar%20yasash/Milliy_oyinchoqlar_yasash.jpg"
        ),
        CategoryResList(
            "Second slider",
            "https://edumonitoring.uz/media/hunar_type/Gilamdo'zlik/Gilamdozlik.jpg"
        ),
        CategoryResList(
            "Third slider",
            "https://edumonitoring.uz/media/hunar_type/Kulolchilik/Kulolchilik.jpg"
        )
    )

    lateinit var sliderAdapter: ImageSliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindTabLayout()
        bindSliderViewPager()
    }

    private fun bindTabLayout() {
        val adapter = FragmentPageAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding!!.tabLayout, binding!!.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Brands"
                1-> tab.text = "Exclusive"
            }
        }.attach()
    }

    private fun bindSliderViewPager() {
        sliderView = binding.categorySlider

        sliderAdapter = ImageSliderAdapter(screens)

        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        sliderView.setSliderAdapter(sliderAdapter)

        sliderView.scrollTimeInSec = 3

        sliderView.isAutoCycle = true

        sliderView.startAutoCycle()
    }
}