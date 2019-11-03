package com.sopt.partyflatform.Latest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.sopt.partyflatform.Api.ApplicationController
import com.sopt.partyflatform.R
import com.sopt.partyflatform.RankingFragment
import kotlinx.android.synthetic.main.fragment_latest.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class LatestFragment : Fragment() {
    private lateinit var latestAdapter : LatestAdapter
    private lateinit var rankingFragment: RankingFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =  inflater.inflate(R.layout.fragment_latest, container, false)

        rankingFragment = RankingFragment()
        v.rankingtxt.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, rankingFragment)?.commit()
        }


        getData(v)

        return v
    }

    private fun getData(v : View) {
        val call = ApplicationController.service.getLatest()

        call.enqueue(object : Callback<GetLatestMainData> {
            override fun onFailure(call: Call<GetLatestMainData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<GetLatestMainData>, response: Response<GetLatestMainData>) {
                if ( response.isSuccessful ) {
                    val body = response.body()

                    val data = body!!.data

                    latestAdapter = LatestAdapter(context!!, data)

                    v.rv_latest_item.adapter = latestAdapter

                    v.rv_latest_item.layoutManager = GridLayoutManager(context, 2)
                    latestAdapter
                    latestAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}
