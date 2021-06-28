package com.example.school21.data.model

import com.google.gson.annotations.SerializedName

class Token(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int
)