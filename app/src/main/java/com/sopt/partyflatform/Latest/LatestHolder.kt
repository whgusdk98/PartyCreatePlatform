package com.sopt.partyflatform.Latest

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.partyflatform.Detail.DetailFragment
import com.sopt.partyflatform.R

class LatestHolder(view: View) : RecyclerView.ViewHolder(view){
    val latest_img_holder : ImageView = view.findViewById(R.id.latest_img)
    val latest_title_holder : TextView = view.findViewById(R.id.latest_title)
    val latest_address_holder : TextView = view.findViewById(R.id.latest_address)
    val latest_date_holder : TextView = view.findViewById(R.id.latest_date)

    fun bind(data: LatestItem){
        Glide.with(itemView).load(data.url).into(latest_img_holder)
        latest_title_holder.text = data.title
        latest_address_holder.text = "#"+data.address
        latest_date_holder.text = "#"+data.date

        itemView.setOnClickListener {
            val activity = itemView.context as? AppCompatActivity
            val args = Bundle()
            args.putInt("idx", data.idx)
            val detailFragment = DetailFragment()
            detailFragment.arguments = args
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, detailFragment)?.commit()
        }
    }
}