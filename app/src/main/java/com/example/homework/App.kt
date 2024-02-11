package com.example.homework

import android.app.Application
import com.example.homework.data.DatabaseManager
import com.example.homework.utils.MySharedPreferences

class App:Application() { var mySharedPreferense: MySharedPreferences? = null

    override fun onCreate() {
        super.onCreate()
        mySharedPreferense = MySharedPreferences(this)
        DatabaseManager.init(this)

    }

    companion object {

    }
}