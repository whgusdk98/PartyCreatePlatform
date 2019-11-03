package com.sopt.partyflatform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.partyflatform.Api.ApplicationController
import com.sopt.partyflatform.Latest.LatestFragment
import kotlinx.android.synthetic.main.fragment_ranking.*
import kotlinx.android.synthetic.main.fragment_ranking.view.*
import com.sopt.partyflatform.R
import com.sopt.partyflatform.Rank.GetRankMainData
import com.sopt.partyflatform.Rank.RankingAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RankingFragment : Fragment() {

    private lateinit var rvRanking: RecyclerView
    private lateinit var rankingAdapter: RankingAdapter
    private lateinit var latestFragment: LatestFragment
    //private var

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        //fragment_rv = view.findViewById(R.id.)

        latestFragment = LatestFragment()

        view.newText.setOnClickListener {
            fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.container, latestFragment)?.commit()
        }
        initRankRepoList(view)
        getData(view)
        return view
    }

    private fun initRankRepoList(v : View){
        rvRanking = v.findViewById(R.id.Ranking_rv)
    }

    private fun getData(v : View) {
        val call = ApplicationController.service.getRank()

        call.enqueue(object : Callback<GetRankMainData> {
            override fun onFailure(call: Call<GetRankMainData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<GetRankMainData>, response: Response<GetRankMainData>) {
                if ( response.isSuccessful ) {
                    val body = response.body()

                    val data = body!!.data

                    rankingAdapter = RankingAdapter(context!!, data)

                    rvRanking.adapter = rankingAdapter

                    rvRanking.layoutManager = LinearLayoutManager(context)

                    rankingAdapter.notifyDataSetChanged()
                }
            }
        })
    }

}
