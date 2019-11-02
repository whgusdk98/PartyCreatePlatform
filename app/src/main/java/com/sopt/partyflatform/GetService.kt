package com.sopt.partyflatform

import retrofit2.Call
import retrofit2.http.GET

interface GetService {

    @GET("/main/info")
    fun getMonthly(
    ): Call<GetMainInfoData>

}