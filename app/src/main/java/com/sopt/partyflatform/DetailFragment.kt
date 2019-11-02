package com.sopt.partyflatform


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    var detail_img_uri = ""
    var detail_title = ""
    var detail_host = ""
    var detail_date = ""
    var detail_txt = ""
    var detail_caution = ""
    var idx = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val detail_view =  inflater.inflate(R.layout.fragment_detail, container, false)

        Log.d("detailFragment", idx.toString())

        Glide.with(this@DetailFragment)
            .load(detail_img_uri)
            .into(detail_view.detail_img)

        detail_view.detail_title.text = detail_title

        detail_view.detail_host.text = detail_host

        detail_view.detail_date.text = detail_date

        detail_view.detail_txt.text = detail_txt

        detail_view.detail_caution.text = detail_caution

        return detail_view
    }


}
