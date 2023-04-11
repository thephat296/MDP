package com.miu.mdp.assignment5.problem2_3

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val price: Double,
    val itemId: String,
    @DrawableRes val imageRes: Int,
    val desc: String
) : java.io.Serializable