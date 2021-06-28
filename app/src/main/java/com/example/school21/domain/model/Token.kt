package com.example.school21.domain.model

class Token(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int
)