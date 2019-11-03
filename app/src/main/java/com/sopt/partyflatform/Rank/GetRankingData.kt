package com.sopt.partyflatform.Rank

import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class GetRankingData(
val rank: String,
val party: String,
val party_Idx: Int

)

data class GetRankMainData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Rankdata>
)

data class Rankdata(
    @SerializedName("party_idx")
    val idx: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("likeCount")
    val likeCount: Int
)