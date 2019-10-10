package com.example.gotenna_mapbox.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gotenna_mapbox.model.api.LocationService


@Database(entities = arrayOf(LocationService::class),version =1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun locationService(): LocationService

    companion object{
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "SavedLocations")
            .build()
    }
}