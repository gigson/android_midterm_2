package com.example.second_midterm

import android.app.Application
import androidx.room.Room

/*
* Created by ნიკოლოზ კაციტაძე on 5/21/20
*/

class App : Application() {

    lateinit var db: AppDatabase

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "APP_DATABASE"
        ).allowMainThreadQueries().build()

    }

}