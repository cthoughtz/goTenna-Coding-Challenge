package com.example.gotenna_mapbox.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gotenna_mapbox.R
import com.example.gotenna_mapbox.model.Location
import kotlinx.android.synthetic.main.items_list.view.*

class LocationAdapter(private val locationArray: MutableList<Location>): RecyclerView.Adapter<LocationAdapter.LocationHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= LocationHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
    )

    fun update(update: MutableList<Location>){
        locationArray.clear()
        locationArray.addAll(update)
        notifyDataSetChanged()
    }

    override fun getItemCount()= locationArray.size

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        holder.bind(locationArray[position])
    }

    class LocationHolder(v: View):RecyclerView.ViewHolder(v), View.OnClickListener{

        val name = v.tvName
        val lat = v.tvLat
        val lng = v.tvLng
        val desc = v.tvDesc

        fun bind(location: Location){
            name.text = location.name
            lat.text = location.lat.toString()
            lng.text = location.lng.toString()
            desc.text = location.desc.toString()

        }
        override fun onClick(click: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}