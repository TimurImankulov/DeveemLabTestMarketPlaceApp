package com.example.marketplaceapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductModel(
    val image: Int,
    val price: String,
    val currency: String,
    val measure: String,
    val description: String,
    val location: String,
    val views: String,
    val data: String,
    val title: String
) : Parcelable