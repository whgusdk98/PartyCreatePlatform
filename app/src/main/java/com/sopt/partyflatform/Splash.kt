package com.sopt.partyflatform

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try
        {
            Thread.sleep(2000); //3초 인트로화면 보여주기
            val intent = Intent(this, MainActivity::class.java)            // 실제 사용할 메인 액티비티
            startActivity(intent)
            finish()

        }
        catch (e: Exception)
        {
            return;
        }



    }

}