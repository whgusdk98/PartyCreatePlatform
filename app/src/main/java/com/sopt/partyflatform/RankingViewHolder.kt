package com.sopt.partyflatform

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
import kotlinx.android.synthetic.main.li_rank_item.view.*

class RankingViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val rank_value: TextView = view.findViewById(R.id.rank_value)
    val postImage: ImageView = view.findViewById(R.id.postImage)
    val partyName: TextView = view.findViewById(R.id.partyName)
    //val party_Idx: Int
    fun bind(data: GetRankingData){
        rank_value.text = data.rank
        postImage.setImageResource(data.poster)
        partyName.text = data.party
        var party_Idx = data.party_Idx

        itemView.setOnClickListener{
            //val context = it.context
            val activity = itemView.context as? AppCompatActivity

            val detailFragment = DetailFragment()
            detailFragment.idx = party_Idx
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, detailFragment)?.commit()

        }

    }

}