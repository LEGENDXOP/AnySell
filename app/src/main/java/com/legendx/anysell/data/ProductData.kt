package com.legendx.anysell.data

data class ProductData(
    val title: String,
    val shortDescription: String,
    val longDescription: String? = null,
    val imageURL: List<String>?= null,
    val price: Int,
    val category: Int,
    val ratings: Float = 0f
)