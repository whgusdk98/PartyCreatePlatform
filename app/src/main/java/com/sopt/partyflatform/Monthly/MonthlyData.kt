package com.sopt.partyflatform.Monthly

import com.google.gson.annotations.SerializedName

data class GetMonthlyMainInfoData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<MonthlyData>
)

data class MonthlyData(
    @SerializedName("party_idx")
    val idx: Int,
    @SerializedName("image")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("address")
    val address: String
)