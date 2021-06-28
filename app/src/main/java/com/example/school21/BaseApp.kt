package com.example.school21

import android.app.Application
import android.widget.Toast
import com.example.school21.data.model.Token
import com.example.school21.domain.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApp : Application() {
    private lateinit var mainToken: Token

    override fun onCreate() {
        super.onCreate()

        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val school42Api = retrofit.create(School42Api::class.java)

        school42Api.getToken(GRANT_TYPE, UID, SECRET_KEY)
            .enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if (response.isSuccessful) {
                        val token = response.body()
                        mainToken = Token(token!!.accessToken, token.tokenType, token.expiresIn)
                        Toast.makeText(applicationContext, mainToken.accessToken, Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
                }

            })

//        val result = school42Api.getUser(mainToken.accessToken, "dshala")
//
//        result.enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
////                Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//            }
//
//        })
    }

    companion object {
        private const val SECRET_KEY =
            "3b0a8351fb5a528eb87280f41cfda1f0b5ce95fb300b3cac42654d7bc13189a1"
        private const val UID = "e41ba478e4473ad51708f9c2754a57a127d57412eb933ecd37aec531111fa9f7"
        private const val BASE_URL = "https://api.intra.42.fr/"
        private const val GRANT_TYPE = "client_credentials"
    }
}