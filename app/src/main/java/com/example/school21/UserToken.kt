package com.example.school21

import com.example.school21.domain.model.Token

class UserToken(
    val secretKey: String,
    val uid: String,
    val grantType: String
) : Token()