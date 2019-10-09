package com.example.gotenna_mapbox.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("latitude") val lat: Float?,
    @SerializedName("longitude") val lng: Float?,
    @SerializedName("description") val desc: String?
    )