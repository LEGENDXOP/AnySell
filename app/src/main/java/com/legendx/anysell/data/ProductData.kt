package com.legendx.anysell.data

data class ProductData(
    val title: String,
    val shortDescription: String,
    val longDescription: String? = null,
    val imageURL: String? = null,
    val price: Double,
    val category: Int,
    val ratings: Float = 0f
)
