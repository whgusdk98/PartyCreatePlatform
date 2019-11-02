package com.sopt.partyflatform.Rank

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.partyflatform.R

class RankingAdapter (private val context: Context): RecyclerView.Adapter<RankingViewHolder>(){
    var data = listOf<GetRankingData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.li_rank_item,parent,false)

        return RankingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.bind(data[position])
    }
}