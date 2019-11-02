package com.sopt.partyflatform


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_regist.view.*

/**
 * A simple [Fragment] subclass.
 */
class RegistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val regist_view = inflater.inflate(R.layout.fragment_regist, container, false)

        val item = RegistItem("0","0","0","0","0","0","0")

//        Glide.with(this@RegistFragment)
//            .load(item.regist_img)
//            .into(regist_view.regist_img)
//
//        regist_view.regist_title.text = item.regist_title
//
//        regist_view.regist_host.text = item.regist_host
//
//        regist_view.regist_date.text = item.regist_date


        return regist_view

    }


}
