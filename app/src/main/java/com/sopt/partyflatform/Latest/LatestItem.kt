package com.sopt.partyflatform.Latest

import com.google.gson.annotations.SerializedName

data class GetLatestMainData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<LatestItem>
)

data class LatestItem(
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