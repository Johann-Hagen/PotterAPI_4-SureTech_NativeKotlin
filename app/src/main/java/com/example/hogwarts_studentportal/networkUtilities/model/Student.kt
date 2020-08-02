package com.example.hogwarts_studentportal.networkUtilities.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Student(
       @SerializedName("bloodStatus")
       val bloodStatus: String = "",
       @SerializedName("deathEater")
    val deathEater: Boolean = false,
    @SerializedName("dumbledoresArmy")
    val dumbledoresArmy: Boolean = false,
    @SerializedName("house")
    val house: String = "",
    @SerializedName("_id")
    val id: String = "",
    @SerializedName("ministryOfMagic")
    val ministryOfMagic: Boolean = false,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("orderOfThePhoenix")
    val orderOfThePhoenix: Boolean = false,
    @SerializedName("role")
    val role: String = "",
    @SerializedName("species")
    val species: String = ""
    ): Serializable