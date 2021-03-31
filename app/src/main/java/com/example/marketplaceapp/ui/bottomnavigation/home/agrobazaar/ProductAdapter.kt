package com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplaceapp.data.model.ProductModel
import com.example.marketplaceapp.databinding.ItemProductBinding
import com.example.marketplaceapp.utils.diffUtils.DiffUtilsItems
import com.example.marketplaceapp.utils.ext.setCornerRadius
import com.squareup.picasso.Picasso


class ProductAdapter(private val listener: () -> Unit) :
    ListAdapter<ProductModel, ProductViewHolder>(
        DiffUtilsItems.diffUtilItems
    ) {

    private val list = arrayListOf<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = ItemProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(itemPersonBinding)
    }

    fun update(list: ArrayList<ProductModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount() = list.size
}

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ProductModel, listener: () -> Unit) {
        binding.tvPrice.text = item.price
        binding.tvCurrency.text = item.currency
        binding.tvMeasure.text = item.measure
        binding.tvDescription.text = item.description
        binding.tvLocation.text = item.location

        Picasso.get().load(item.image).into(binding.ivImage)

        binding.ivImage.setCornerRadius(
            topLeft = 10f,
            topRight = 10f,
            bottomLeft = 10f,
            bottomRight = 10f
        )

        binding.cardProduct.setOnClickListener {
            listener.invoke()
        }
    }
}