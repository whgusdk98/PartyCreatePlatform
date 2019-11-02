package com.sopt.partyflatform


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class RankingFragment : Fragment() {

    private lateinit var rvRanking: RecyclerView
    private lateinit var rankingAdapter: RankingAdapter
    //private var

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        //fragment_rv = view.findViewById(R.id.)

        initRankRepoList(view)
        return view
    }

    private fun initRankRepoList(v : View){
        rvRanking = v.findViewById(R.id.Ranking_rv)
        rankingAdapter = RankingAdapter(context!!)
        rankingAdapter.data = listOf(
            GetRankingData(
                rank = "1",
                poster = R.drawable.dog,
                party = "Halloween Party"
            ),
            GetRankingData(
                rank = "2",
                poster = R.drawable.dog,
                party = "Christmas Party"
            ),
            GetRankingData(
                rank = "3",
                poster = R.drawable.dog,
                party = "New Year Party"
        )
        )
        rvRanking.adapter = rankingAdapter
        rvRanking.layoutManager = LinearLayoutManager(context)
    }

}
