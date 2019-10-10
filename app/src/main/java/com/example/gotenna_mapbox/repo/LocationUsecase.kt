package com.example.gotenna_mapbox.repo

import com.example.gotenna_mapbox.model.Location
import io.reactivex.Observable

interface LocationUsecases{
    fun getLocation(): Observable<MutableList<Location>>
}