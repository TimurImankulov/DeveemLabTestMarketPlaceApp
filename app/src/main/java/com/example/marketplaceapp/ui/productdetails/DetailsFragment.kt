package com.example.marketplaceapp.ui.productdetails

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marketplaceapp.R
import com.example.marketplaceapp.databinding.FragmentDetailsBinding
import com.example.marketplaceapp.utils.ext.viewBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.title = ""
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_app_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.favorite -> Toast.makeText(context, "Favorite", Toast.LENGTH_LONG).show()
            R.id.share -> Toast.makeText(context, "Share", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupViews() {
        binding.tvViews.text = args.details?.views
        binding.tvLocation.text = args.details?.location
        binding.tvDate.text = args.details?.data
        binding.tvTitle.text = args.details?.title
        binding.tvPrice.text = args.details?.price
        binding.tvCurrency.text = args.details?.currency
        binding.tvDescription.text = args.details?.description

        args.details?.image?.let {
            Picasso.get()
                .load(it)
                .into(binding.ivImage)
        }
    }
}