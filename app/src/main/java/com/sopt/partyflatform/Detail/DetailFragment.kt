package com.sopt.partyflatform.Detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sopt.partyflatform.Api.ApplicationController
import com.sopt.partyflatform.R
import kotlinx.android.synthetic.main.fragment_detail.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val detail_view = inflater.inflate(R.layout.fragment_detail, container, false)

        val args = arguments
        val idx = args?.getInt("idx")!!

        getsetData(detail_view, idx)

        return detail_view
    }

    private fun getsetData(v : View, idx : Int) {
        val call = ApplicationController.service.getDetail(idx)

        call.enqueue(object : Callback<GetDetailMainInfoData> {
            override fun onFailure(call: Call<GetDetailMainInfoData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<GetDetailMainInfoData>, response: Response<GetDetailMainInfoData>) {
                if ( response.isSuccessful ) {
                    val body = response.body()
                    val item : DetailData = body!!.data[0]
                    Glide.with(this@DetailFragment).load(item.url).into(v.detail_img)
                    v.detail_title.text = item.title
                    v.detail_host.text = item.host
                    v.detail_like.text = item.likeCount.toString()
                    v.detail_place.text = item.address
                    v.detail_date.text = item.date
                    v.detail_txt.text = item.content
                    v.detail_caution.text = item.please
                }
            }
        })
    }


}
