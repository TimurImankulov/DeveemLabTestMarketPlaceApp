package com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.common.BaseFragment
import com.example.marketplaceapp.data.model.ProductModel
import com.example.marketplaceapp.databinding.FragmentAgrobazaarBinding
import com.example.marketplaceapp.utils.ext.viewBinding
import com.example.marketplaceapp.utils.viewModel

class AgrobazaarFragment() : BaseFragment() {
    override fun resID() = R.layout.fragment_agrobazaar
    private val viewModel by viewModel(AgrobazaarViewModel::class)
    private val binding by viewBinding(FragmentAgrobazaarBinding::bind)
    private val adapter by lazy {
        ProductAdapter() {
            navigateToDetails(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewProduct.adapter = adapter
        binding.recyclerViewProduct.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setupViewModel() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    private fun navigateToDetails(data: ProductModel) {
        val destination = AgrobazaarFragmentDirections.toDetailsFragment(data)
        findNavController().navigate(destination)
    }
}