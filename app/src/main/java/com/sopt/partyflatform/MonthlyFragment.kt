package com.sopt.partyflatform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_monthly.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MonthlyFragment : Fragment() {

    private lateinit var detailFragment: DetailFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_monthly, container, false)

        detailFragment = DetailFragment()
        getsetData(v)

        return v
    }

    private fun getsetData(v : View) {
        val call = ApplicationController.service.getMonthly()

        call.enqueue(object : Callback<GetMainInfoData> {
            override fun onFailure(call: Call<GetMainInfoData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<GetMainInfoData>, response: Response<GetMainInfoData>) {
                if ( response.isSuccessful ) {
                    val body = response.body()
                    val item : MonthlyData = body!!.data[0]

                    Glide.with(this@MonthlyFragment).load(item.url).into(v.iv_image)
                    v.tv_title.text = item.title
                    v.tv_date.text = item.date
                    v.tv_address.text = item.address

                    v.btn_detail.setOnClickListener {
                        val args = Bundle()
                        args.putInt("idx", item.idx)
                        detailFragment.arguments = args
                        fragmentManager?.beginTransaction()?.replace(R.id.container, detailFragment)?.commit()
                    }
                }
            }
        })
    }

}
