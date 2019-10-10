package com.example.gotenna_mapbox

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.gotenna_mapbox.room.AppDatabase

open class App : Application(){
    companion object {
        @Volatile
        lateinit var locationDB: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        locationDB = buildDatabase(this)
    }

    private fun buildDatabase(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "SavedLocations.db"
    ).build()
}