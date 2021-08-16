package com.example.school21

import android.app.Application
import com.example.school21.data.api.School42ApiTalker
import com.example.school21.data.repository.UserRepository
import com.example.school21.domain.interactors.UserInteractor

class BaseApp : Application() {
    private lateinit var interactor: UserInteractor

    override fun onCreate() {
        super.onCreate()

        val apiTalker = School42ApiTalker(BASE_URL)
        val repository = UserRepository(apiTalker)
        interactor = UserInteractor(repository)
    }

    companion object {
        private const val BASE_URL = "https://api.intra.42.fr/"
    }
}