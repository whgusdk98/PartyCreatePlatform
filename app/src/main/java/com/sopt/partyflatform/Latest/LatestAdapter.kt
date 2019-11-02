package com.sopt.partyflatform.Latest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.partyflatform.R

class LatestAdapter(private val context : Context, private var data : List<LatestItem>) : RecyclerView.Adapter<LatestHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.li_latest_item, parent, false)

        return LatestHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LatestHolder, position: Int) {
        holder.bind(data[position])
    }
}