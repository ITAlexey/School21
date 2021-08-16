package com.example.school21.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class School42ApiTalker(private val baseUrl: String) : BaseApiTalker() {
    private var client: School42Api = createApiClient()

    private fun createApiClient(): School42Api {
        val httpLoginInterceptor = initHttpLoginInterceptor()
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .build()
        return retrofit.create(School42Api::class.java)
    }

    private fun initHttpLoginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().also { interceptor ->
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }

    fun getToken(grantType: String, uId: String, secret: String) =
        client.getToken(grantType, uId, secret)

    fun getUser(token: String, login: String) =
        client.getUser(token, login)

    fun getUserCoalitions(token: String, login: String) =
        client.getUserCoalitions(token, login)
}