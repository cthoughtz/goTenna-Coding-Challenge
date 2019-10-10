package com.example.gotenna_mapbox.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.view.activities.MainActivity
import com.example.gotenna_mapbox.viewmodel.LocationViewModel
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap

class MapFragment : Fragment(){


    private lateinit var mapView: MapView
    lateinit var map: MapboxMap
    lateinit var latLngBounds: LatLngBounds
    lateinit var myViewModel: LocationViewModel
    var test: Float? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Mapbox.getInstance(view.context, getString(R.string.access_token))
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        myViewModel = ViewModelProviders.of(activity!!).get(LocationViewModel::class.java)
        myViewModel.locationInformation.observe(this, Observer { info ->

            val cadman = LatLng(info.get(0).lat!!.toDouble(), info.get(0).lng!!.toDouble())
            val borough = LatLng(info.get(1).lat!!.toDouble(), info.get(1).lng!!.toDouble())
            val dos = LatLng(info.get(2).lat!!.toDouble(), info.get(2).lng!!.toDouble())
            val golden = LatLng(info.get(3).lat!!.toDouble(), info.get(3).lng!!.toDouble())

            mapView.getMapAsync(){
                map = it
                    map.addMarker(MarkerOptions().position(cadman))
                    map.addMarker(MarkerOptions().position(borough))
                    map.addMarker(MarkerOptions().position(dos))
                    map.addMarker(MarkerOptions().position(golden))
            }
        })
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (outState != null) {
            mapView.onSaveInstanceState(outState)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
