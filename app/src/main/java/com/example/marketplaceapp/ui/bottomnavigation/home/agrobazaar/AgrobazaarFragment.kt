package com.example.marketplaceapp.ui.bottomnavigation.home.agrobazaar

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.marketplaceapp.R
import com.example.marketplaceapp.data.common.BaseFragment
import com.example.marketplaceapp.databinding.FragmentAgrobazaarBinding
import com.example.marketplaceapp.utils.ext.viewBinding
import com.example.marketplaceapp.utils.viewModel

class AgrobazaarFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_agrobazaar
    private val viewModel by viewModel(AgrobazaarViewModel::class)
    private val binding by viewBinding(FragmentAgrobazaarBinding::bind)
    private val adapter by lazy { ProductAdapter(){
        navigateToDetails()
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewProduct.adapter = adapter
        binding.recyclerViewProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun setupViewModel() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    private fun navigateToDetails() {
        val destination = AgrobazaarFragmentDirections.actionAgrobazaarFragmentToDetailsFragment()
        findNavController().navigate(destination)
    }
}