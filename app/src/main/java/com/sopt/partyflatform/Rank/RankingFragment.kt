package com.sopt.partyflatform


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_ranking.*
import kotlinx.android.synthetic.main.fragment_ranking.view.*
import com.sopt.partyflatform.R
import com.sopt.partyflatform.Rank.GetRankingData
import com.sopt.partyflatform.Rank.RankingAdapter

/**
 * A simple [Fragment] subclass.
 */
class RankingFragment : Fragment() {

    private lateinit var rvRanking: RecyclerView
    private lateinit var rankingAdapter: RankingAdapter


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
                party = "Halloween Party",
                party_Idx = 0
            ),
            GetRankingData(
                rank = "2",
                party = "Christmas Party",
                party_Idx = 0
            ),
            GetRankingData(
                rank = "3",
                party = "New Year Party",
                party_Idx = 0
        ),
            GetRankingData(
                rank = "4",
                party = "New Year Party",
                party_Idx = 0
        ),
            GetRankingData(
                rank = "5",
                party = "Christmas Party",
                party_Idx = 0
            ),
            GetRankingData(
                rank = "6",
                party = "Halloween Party",
                party_Idx = 0
            )
        )
        rvRanking.adapter = rankingAdapter
        rvRanking.layoutManager = LinearLayoutManager(context)
    }

}
