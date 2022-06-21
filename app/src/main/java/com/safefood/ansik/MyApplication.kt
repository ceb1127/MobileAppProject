package com.safefood.ansik

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApplication:Application() {
    companion object{
        var networkService: NetworkService
        val retrofit : Retrofit
            get() = Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/B553748/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(NetworkService::class.java)
        }
    }

}