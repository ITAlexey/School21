package com.example.school21.data.repository

import com.example.school21.data.api.School42ApiTalker
import com.example.school21.domain.model.Token

class UserRepository(
    private val apiTalker: School42ApiTalker
) {
    private var token: Token? = null

    fun getUserByLogin(login: String) {
        if (token == null) {
            getToken()
        } else {
            apiTalker.getUser(token.accessToken, login)
        }
    }

    fun getUserCoalitionsByLogin(login: String) {
        apiTalker.getUserCoalitions(token.accessToken, login)
    }

    private fun getToken() {
        apiTalker.getToken(tokenData.grantType, tokenData.uid, tokenData.secretKey)
    }

}