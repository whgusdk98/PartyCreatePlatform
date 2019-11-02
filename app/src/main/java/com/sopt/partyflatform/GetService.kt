package com.sopt.partyflatform

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface GetService {

    @GET("/main/info")
    fun getMonthly(
    ): Call<GetMainInfoData>

    @POST("party/enroll")
    fun postEventRegisterResponse(

    )
}