package com.example.gotenna_mapbox.model.api

import androidx.room.Dao
import com.example.gotenna_mapbox.model.Location
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET


interface LocationService {
    @GET("/development/scripts/get_map_pins.php")
    fun getLocationInfo(): Observable<MutableList<Location>>
}