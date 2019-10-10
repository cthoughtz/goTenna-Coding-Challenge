package com.example.gotenna_mapbox.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gotenna_mapbox.model.Location


@Database(entities = [Location::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationService(): LocationDao

}