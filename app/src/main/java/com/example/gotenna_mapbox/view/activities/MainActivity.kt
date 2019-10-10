package com.example.gotenna_mapbox.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.Navigation.findNavController
import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.repo.LocationRepo
import com.example.gotenna_mapbox.viewmodel.LocationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

     lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationViewModel = ViewModelProviders.of(this,object :
            ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LocationViewModel(LocationRepo()) as T
            }
        }).get(LocationViewModel::class.java)
        locationViewModel.fetchLocationInfo()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.location_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.toolbarIcon -> {
                if (item.isChecked) {
                    item.isChecked = false
                    item.setIcon(R.drawable.ic_map_white_24dp)
                    findNavController(this, R.id.navHostFragment).navigate(R.id.listFragment)
                    return true
                } else {
                    item.isChecked = true
                    item.setIcon(R.drawable.ic_menu_white_24dp)
                    findNavController(this, R.id.navHostFragment).navigate(R.id.mapFragment)
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
