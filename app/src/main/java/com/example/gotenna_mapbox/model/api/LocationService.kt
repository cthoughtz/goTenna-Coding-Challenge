package com.example.gotenna_mapbox.model.api

import com.example.gotenna_mapbox.model.Location
import io.reactivex.Single
import retrofit2.http.GET

interface LocationService {

    @GET("/development/scripts/get_map_pins.php")
    fun getLocationInfo(): Single<ArrayList<Location>>
}