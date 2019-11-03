package com.sopt.partyflatform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.sopt.partyflatform.Latest.LatestFragment
import com.sopt.partyflatform.Monthly.MonthlyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blankFragment: BlankFragment
    private lateinit var monthlyFragment: MonthlyFragment
    private lateinit var latestFragment: LatestFragment
    private lateinit var registFragment: RegistFragment
    private lateinit var rankingFragment: RankingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blankFragment = BlankFragment()
        monthlyFragment = MonthlyFragment()
        latestFragment = LatestFragment()
        registFragment = RegistFragment()
        rankingFragment = RankingFragment()
        setFrag(1)
        bottomNavi()

        Toast.makeText(this, "자동 로그인 성공", Toast.LENGTH_SHORT).show()
    }


    private fun setFrag(n : Int) {
        val fm : FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        when (n) {
            0 -> { // 목록
                ft.replace(R.id.container, rankingFragment)
                ft.commit() }
            1 -> { // 이달의 행사
                ft.replace(R.id.container, monthlyFragment)
                ft.commit() }
            2 -> { // 등록
                ft.replace(R.id.container, registFragment)
                ft.commit() }
            }
        }


    private fun bottomNavi() {
        bottomNavigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_list -> {
                    setFrag(0)
                }
                R.id.menu_monthly -> {
                    setFrag(1)
                }
                R.id.menu_write -> {
                    setFrag(2)
                }
            }
            true
        }
    }

}
