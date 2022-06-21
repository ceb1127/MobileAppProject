package com.safefood.ansik

import com.google.gson.annotations.SerializedName

data class FoodPageListModel(
    @SerializedName("list")
    val data:MutableList<FoodItemModel>
    )
