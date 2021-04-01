package com.example.marketplaceapp.utils.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.marketplaceapp.data.model.ProductModel

object DiffUtilsItems {

    val diffUtilItems = object : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.image == newItem.image
                    && oldItem.price == newItem.price
                    && oldItem.currency == newItem.currency
                    && oldItem.measure == newItem.measure
                    && oldItem.description == newItem.description
                    && oldItem.location == newItem.location
                    && oldItem.title == newItem.title
                    && oldItem.views == newItem.views
                    && oldItem.data == newItem.data
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }
    }
}
