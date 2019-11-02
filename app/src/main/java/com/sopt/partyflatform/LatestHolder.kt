package com.sopt.partyflatform

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LatestHolder(view: View) : RecyclerView.ViewHolder(view){
    val latest_img_holder : ImageView = view.findViewById(R.id.latest_img)
    val latest_title_holder : TextView = view.findViewById(R.id.latest_title)

    fun bind(data:LatestItem){
        Glide.with(itemView).load(data.latest_img).into(latest_img_holder)
        latest_title_holder.text = data.latest_title
    }
}