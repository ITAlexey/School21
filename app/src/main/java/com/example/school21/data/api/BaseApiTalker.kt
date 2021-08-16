package com.example.school21.data.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseApiTalker {

    fun <T> proccessServerCall(callResponse: Call<T>) {
        callResponse.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val responseBody: T? = response.body()
                if (response.isSuccessful && responseBody != null)
                {
                    // retrieving data from response and save to out model
                    // (need to think about best approach)
                } else {
                   // 404 400 errors - show according problem
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                // notify user that something wrong with ethernet connection
            }

        })
    }

    companion object {
        private const val NETWORK_FAIL = "..."
    }
}