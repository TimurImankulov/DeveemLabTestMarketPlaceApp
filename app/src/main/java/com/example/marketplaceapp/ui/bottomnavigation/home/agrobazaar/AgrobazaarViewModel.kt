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
        list.add(ProductModel(image = R.drawable.house, price = "20000", currency = "USD", measure = "за 1 шт", description = "Продаю 5 комнат", location = "Кант", views = "100 просмотров", data = "03 Май, 2020", title = "Продаю дом"))
        list.add(ProductModel(image = R.drawable.dried_fruits, price = "180", currency = "KGZ", measure = "за 1 кг", description = "Продаю сухофрукты", location = "Джалал-Абад", views = "289 просмотров", data="04 Май, 2020", title = "Продаю сухофрукты"))
        list.add(ProductModel(image = R.drawable.apples, price = "50", currency = "KGZ", measure = "за 1 кг", description = "Продаю яблоки", location = "Бишкек", views = "240 просмотров", data  = "05 Май, 2020", title = "Продаю яблоки"))
        list.add(ProductModel(image = R.drawable.parsley, price = "20", currency = "KGZ", measure = "за 1 шт", description = "Продаю петрушку", location = "Сокулук", views = "350 просмотров", data = "06 Май, 2020", title = "Продаю петрушку"))
        list.add(ProductModel(image = R.drawable.wheat, price = "20", currency = "KGZ", measure = "за 1 кг", description = "Продаю пшеницу, оптом", location = "Нарын", views = "400 просмотров", data = "07 Май, 2020", title = "Продаю пшеницу"))
        list.add(ProductModel(image = R.drawable.harvester, price = "15000", currency = "USD", measure = "за 1 шт", description = "Продаю комбайн", location = "Беловодск", views = "200 просмотров", data = "08 Май, 2020", title = "Продаю комбайн"))
        list.add(ProductModel(image = R.drawable.onion, price = "30", currency = "KGZ", measure = "за 1 кг", description = "Продаю лук, оптом", location = "Баткен", views = "200 просмотров", data = "09 Май, 2020", title = "Продаю лук"))
        list.add(ProductModel(image = R.drawable.pepper, price = "90", currency = "KGZ", measure = "за 1 кг", description = "Продаю перец", location = "Ош", views = "340 просмотров", data = "10 Май, 2020", title = "Продаю перец"))
        list.add(ProductModel(image = R.drawable.beans, price = "60", currency = "KGZ", measure = "за 1 кг", description = "Продаю фасоль", location = "Талас", views = "450 просмотров", data = "11 Май, 2020", title = "Продаю фасоль"))
        list.add(ProductModel(image = R.drawable.tomato, price = "200", currency = "KGZ", measure = "за 1 кг", description = "Продаю помидоры", location = "Бишкек", views = "700 просмотров", data = "12 Май, 2020", title = "Продаю помидоры"))

        data.postValue(list)
    }
}

