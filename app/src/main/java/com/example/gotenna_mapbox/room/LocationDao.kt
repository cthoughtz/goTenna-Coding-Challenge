package com.example.gotenna_mapbox.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gotenna_mapbox.model.Location
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface LocationDao {

    @Query("Select * from savedlocations")
    fun getLocationInfo(): Observable<MutableList<Location>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLocations(locations: MutableList<Location>)

}