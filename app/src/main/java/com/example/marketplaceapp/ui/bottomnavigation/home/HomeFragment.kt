package com.example.marketplaceapp.ui.bottomnavigation.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.common.BaseFragment
import com.example.marketplaceapp.databinding.FragmentHomeBinding
import com.example.marketplaceapp.utils.ext.viewBinding
import com.example.marketplaceapp.utils.viewModel
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_home
    private val viewModel by viewModel(HomeViewModel::class)
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val adapter by lazy { PagerAdapter(requireActivity()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupViewModel()
    }

    private fun setupViewPager() {
        if(binding.viewPager.adapter == null){
            binding.viewPager.adapter = adapter
            binding.viewPager.isUserInputEnabled = false
        }

    }

    private fun setupViewModel() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            adapter.update(it)

            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                tab.text = adapter.getCurrentItem(pos).title
            }.attach()
        })
    }
}