package com.example.gotenna_mapbox.view.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.view.adapters.LocationAdapter
import com.example.gotenna_mapbox.viewmodel.LocationViewModel
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    var locationList = ArrayList<Location>()
    val locationAdapter = LocationAdapter(arrayListOf())

    lateinit var myViewModel: LocationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val divider = DividerItemDecoration(rlist.context, DividerItemDecoration.VERTICAL)
        myViewModel = ViewModelProviders.of(activity!!).get(LocationViewModel::class.java)

        rlist.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = locationAdapter
            addItemDecoration(divider)
        }



        myViewModel.locationInformation.observe(this, Observer { info ->
                locationAdapter.update(info)
        })
    }
}
