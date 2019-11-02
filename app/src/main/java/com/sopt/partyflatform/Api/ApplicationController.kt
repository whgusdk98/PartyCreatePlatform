package com.sopt.partyflatform.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApplicationController {
    private const val BASE_URL = "http://13.209.233.217:3000"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: GetService = retrofit.create(
        GetService::class.java)
}