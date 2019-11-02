package com.sopt.partyflatform


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_latest.view.*

/**
 * A simple [Fragment] subclass.
 */
class LatestFragment : Fragment() {
    private lateinit var latestAdapter : LatestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =  inflater.inflate(R.layout.fragment_latest, container, false)

        latestAdapter = LatestAdapter(context!!)
        latestAdapter.data = listOf(
            LatestItem(
                latest_img = "1",
                latest_title = "1"
            ),
            LatestItem(
                latest_img = "2",
                latest_title = "2"
            ),
            LatestItem(
                latest_img = "3",
                latest_title = "3"
            ),
            LatestItem(
                latest_img = "4",
                latest_title = "4"
            )
        )

        v.rv_latest_item.adapter = latestAdapter

        v.rv_latest_item.layoutManager = GridLayoutManager(context, 2)



        latestAdapter.notifyDataSetChanged()

        return v
    }
}
