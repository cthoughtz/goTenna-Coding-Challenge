package com.example.gotenna_mapbox.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "SavedLocations")
data class Location(
    @PrimaryKey
    @SerializedName("id") val id: Int?,

    @ColumnInfo
    @SerializedName("name") val name: String?,

    @ColumnInfo
    @SerializedName("latitude") val lat: Float?,

    @ColumnInfo
    @SerializedName("longitude") val lng: Float?,

    @ColumnInfo
    @SerializedName("description") val desc: String?
    )