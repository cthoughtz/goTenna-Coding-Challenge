package com.example.gotenna_mapbox.model.api

import androidx.room.Dao
import com.example.gotenna_mapbox.model.Location
import io.reactivex.Single
import retrofit2.http.GET

@Dao
interface LocationService {

    @GET("/development/scripts/get_map_pins.php")
    fun getLocationInfo(): Single<ArrayList<Location>>
}