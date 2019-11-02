package com.sopt.partyflatform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rankingFragment = RankingFragment()
        supportFragmentManager.beginTransaction().add(R.id.layout, rankingFragment).commit()

    }
}
