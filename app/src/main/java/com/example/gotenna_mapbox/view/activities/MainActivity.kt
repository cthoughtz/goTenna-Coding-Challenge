package com.example.gotenna_mapbox.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import com.example.gotenna_mapbox.viewmodel.LocationViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    public lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
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
                    Toast.makeText(this, "change to map", Toast.LENGTH_LONG).show()
                    return true
                } else {
                    item.isChecked = true
                    item.setIcon(R.drawable.ic_menu_white_24dp)
                    Toast.makeText(this, "change to menu", Toast.LENGTH_LONG).show()
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
