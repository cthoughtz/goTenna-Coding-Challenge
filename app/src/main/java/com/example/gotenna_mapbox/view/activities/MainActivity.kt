package com.example.gotenna_mapbox.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.viewmodel.LocationViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        locationViewModel.fetchLocationInfo()

    }
}
