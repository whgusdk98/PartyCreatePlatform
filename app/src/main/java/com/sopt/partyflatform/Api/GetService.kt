package com.sopt.partyflatform.Api

import com.sopt.partyflatform.Detail.GetDetailMainInfoData
import com.sopt.partyflatform.Latest.GetLatestMainData
import com.sopt.partyflatform.Monthly.GetMonthlyMainInfoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetService {

    @GET("/main/info")
    fun getMonthly(
    ): Call<GetMonthlyMainInfoData>

    @GET("/party/order/new")
    fun getLatest(
    ): Call<GetLatestMainData>

    @GET("/party/order/like")
    fun getRank(
    ): Call<GetLatestMainData>

    @GET("/party/detail/{party_idx}")
    fun getDetail(@Path("party_idx")party_idx: Int
    ): Call<GetDetailMainInfoData>

}