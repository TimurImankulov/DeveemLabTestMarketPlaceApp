package com.example.marketplaceapp.ui.bottomnavigation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.model.ViewPagerModel
import com.example.marketplaceapp.ui.bottomnavigation.home.agrmachinery.AgriculturalMachineryFragment
import com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar.AgrobazaarFragment
import com.example.marketplaceapp.ui.bottomnavigation.home.constmaterials.ConstructionMaterialsFragment

class HomeViewModel:ViewModel() {

    val data = MutableLiveData<ArrayList<ViewPagerModel>>()

    init {
        getDataForViewPager()
    }

    private fun getDataForViewPager(){
        val list = arrayListOf<ViewPagerModel>()
        list.add(ViewPagerModel(AgrobazaarFragment(), "Агробазар", R.drawable.ic_cow))
        list.add(ViewPagerModel(AgriculturalMachineryFragment(), "Сельхоз\nтехника", R.drawable.ic_tractor))
        list.add(ViewPagerModel(ConstructionMaterialsFragment(), "Строительные материалы", R.drawable.ic_tools))

        data.postValue(list)
    }
}