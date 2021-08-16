package com.example.school21.domain.interactors

import com.example.school21.UserToken
import com.example.school21.data.repository.UserRepository
import com.example.school21.domain.model.Token

class UserInteractor(
    private val repository: UserRepository,
) {
    private val token: Token? = null

    fun getUserByLogin(login: String) {
        repository.getUserByLogin(login)
    }

    fun getUserCoalitionsByLogin(login: String) {
        repository.getUserCoalitionsByLogin(login)
    }

    private fun fetchToken()
}