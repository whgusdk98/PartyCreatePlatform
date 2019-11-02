package com.sopt.partyflatform.Detail

import com.google.gson.annotations.SerializedName

data class GetDetailMainInfoData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<DetailData>
)

data class DetailData(
    @SerializedName("image")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("host")
    val host: String,
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("please")
    val please: String
)