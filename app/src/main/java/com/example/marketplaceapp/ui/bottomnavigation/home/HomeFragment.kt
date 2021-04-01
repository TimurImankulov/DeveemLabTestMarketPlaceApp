package com.example.marketplaceapp.ui.bottomnavigation.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.common.BaseFragment
import com.example.marketplaceapp.data.model.ViewPagerModel
import com.example.marketplaceapp.databinding.FragmentHomeBinding
import com.example.marketplaceapp.ui.bottomnavigation.home.agrmachinery.AgriculturalMachineryFragment
import com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar.AgrobazaarFragment
import com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar.AgrobazaarFragmentDirections
import com.example.marketplaceapp.ui.bottomnavigation.home.constmaterials.ConstructionMaterialsFragment
import com.example.marketplaceapp.utils.ext.viewBinding
import com.example.marketplaceapp.utils.viewModel
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_home
    private val viewModel by viewModel(HomeViewModel::class)
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private var adapter: PagerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = PagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        adapter?.update(getDataForViewPager())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = adapter?.getCurrentItem(pos)?.title
        }.attach()

        binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_cow)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_tractor)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_tools)
    }

    private fun getDataForViewPager(): ArrayList<ViewPagerModel> {
        val list = arrayListOf<ViewPagerModel>()
        list.add(ViewPagerModel(AgrobazaarFragment(), "Агробазар", R.drawable.ic_cow))
        list.add(ViewPagerModel(AgriculturalMachineryFragment(), "Сельхоз\nтехника", R.drawable.ic_tractor))
        list.add(ViewPagerModel(ConstructionMaterialsFragment(), "Строительные материалы", R.drawable.ic_tools))

        return list
    }
}