package com.sopt.partyflatform.Util

import android.content.Context

object SharedPreferenceController {
    private val ID = "id"

    //아이디 보내기, 가져오기
    fun setId(context: Context, id:String){
        val pref = context.getSharedPreferences(ID, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(ID, id)
        editor.commit()
    }

    fun getId(context: Context) : String? {
        val pref = context.getSharedPreferences(ID, Context.MODE_PRIVATE)
        return pref.getString(ID, "")
    }
}