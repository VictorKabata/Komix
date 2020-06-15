package com.vickikbt.comix.data.api

import com.vickikbt.comix.util.EnviromentVariables.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val retrofitService: ApiService = getRetrofitInstance().create(ApiService::class.java)
    }

}