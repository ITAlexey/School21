package com.example.school21.data.api

import com.example.school21.data.model.Coalition
import com.example.school21.data.model.Token
import com.example.school21.domain.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Header

interface School42Api {

    @FormUrlEncoded
    @POST("oauth/token")
    fun getToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Call<Token>

    @GET("v2/users/{login}")
    fun getUser(
        @Header("Authorization") token: String,
        @Path("login") login: String
    ): Call<User>

    @GET("v2/users/{login}/coalitions")
    fun getUserCoalitions(
        @Header("Authorization") token: String,
        @Path("login") login: String
    ): Call<List<Coalition>>
}