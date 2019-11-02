package com.sopt.partyflatform.Rank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.partyflatform.Detail.DetailFragment
import com.sopt.partyflatform.R

class RankingViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val rank_value: TextView = view.findViewById(R.id.rank_value)
    val partyName: TextView = view.findViewById(R.id.partyName)
    val chartCircle: ImageView = view.findViewById(R.id.chartCircle)
    //val party_Idx: Int  이미지의 setdrawable을 바꿈
    fun bind(data: GetRankingData){
        rank_value.text = data.rank
        partyName.text = data.party
        var party_Idx = data.party_Idx

        if(Integer.parseInt(data.rank) < 4){
            chartCircle.setImageResource(R.drawable.chartcircle)
        }else{
            chartCircle.setImageResource(R.drawable.chartcircle_b)
        }

        itemView.setOnClickListener{
            //val context = it.context
            val activity = itemView.context as? AppCompatActivity

            val detailFragment = DetailFragment()
            // detailFragment.idx = party_Idx
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, detailFragment)?.commit()

        }

    }

}