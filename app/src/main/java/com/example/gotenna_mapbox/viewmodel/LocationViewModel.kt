package com.example.gotenna_mapbox.viewmodel

import android.os.Build.VERSION_CODES.M
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.model.api.LocationApiClient
import com.example.gotenna_mapbox.model.api.LocationService
import com.example.gotenna_mapbox.repo.LocationUsecases
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class LocationViewModel(val usecase: LocationUsecases) : ViewModel() {

    var locationInformation = MutableLiveData<MutableList<Location>>()
    var compositeDisposable= CompositeDisposable()

    fun fetchLocationInfo() {
        compositeDisposable.add(
            usecase.getLocation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    locationInformation.value = it
            }
        )
    }
}