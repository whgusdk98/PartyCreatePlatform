package com.sopt.partyflatform

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.li_rank_item.view.*

class RankingViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val rank_value: TextView = view.findViewById(R.id.rank_value)
    val postImage: ImageView = view.findViewById(R.id.postImage)
    val partyName: TextView = view.findViewById(R.id.partyName)
    fun bind(data: GetRankingData){
        rank_value.text = data.rank
        postImage.setImageResource(data.poster)
        partyName.text = data.party
    }
}