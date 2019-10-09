package com.example.gotenna_mapbox.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.model.api.LocationApiClient
import com.example.gotenna_mapbox.model.api.LocationService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class LocationViewModel() : ViewModel() {

    var locationInformation = MutableLiveData<ArrayList<Location>>()
    var compositeDisposable= CompositeDisposable()

    val api = LocationApiClient


    fun fetchLocationInfo() {
        compositeDisposable.add(
            api?.getLS().getLocationInfo()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.doOnSuccess {
                    locationInformation.postValue(it)
                }?.subscribe()
        )
    }
}