package com.example.school21.data.model

import com.google.gson.annotations.SerializedName

class Coalition(
    val name: String,
    val color: String,
    @SerializedName("image_url")
    val image: String,
    @SerializedName("cover_url")
    val backgroundImage: String?
)