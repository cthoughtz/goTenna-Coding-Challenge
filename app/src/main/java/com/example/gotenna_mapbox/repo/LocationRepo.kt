package com.example.gotenna_mapbox.repo

import com.example.gotenna_mapbox.App.Companion.locationDB
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.model.api.LocationApiClient.locationService
import io.reactivex.Observable

open class LocationRepo : LocationUsecases {

    override fun getLocation(): Observable<MutableList<Location>> {
        return Observable.mergeArray(
            locationDB.locationService().getLocationInfo(),
            locationService.getLocationInfo().doOnNext {
                locationDB.locationService().saveLocations(it)
            }
        )
    }


}