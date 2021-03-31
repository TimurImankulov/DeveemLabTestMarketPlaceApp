package com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.model.ProductModel

class AgrobazaarViewModel : ViewModel() {

    val data = MutableLiveData<ArrayList<ProductModel>>()

    init {
        getDataForRecyclerView()
    }

    private fun getDataForRecyclerView() {
        val list = arrayListOf<ProductModel>()
        list.add(ProductModel(image = R.drawable.image_one, price = "180", currency = "KGZ", measure = "за 1 кг", description = "Продаю сухофрукты", location = "Джалал-Абад"))
        list.add(ProductModel(image = R.drawable.image_two, price = "180", currency = "KGZ", measure = "за 1 кг", description = "Продаю сухофрукты", location = "Бишкек"))
        list.add(ProductModel(image = R.drawable.image_two, price = "180", currency = "KGZ", measure = "за 1 кг", description = "Продаю сухофрукты", location = "Кант"))
        list.add(ProductModel(image = R.drawable.image_two, price = "180", currency = "KGZ", measure = "за 1 кг", description = "Продаю сухофрукты", location = "Кемин"))

        data.postValue(list)
    }
}

