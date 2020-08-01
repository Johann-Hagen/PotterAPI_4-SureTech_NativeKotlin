package com.example.hogwarts_studentportal.networkUtilities.typeClasses


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class House(
    @SerializedName("colors")
    val colors: List<String> = listOf(),
    @SerializedName("founder")
    val founder: String = "",
    @SerializedName("headOfHouse")
    val headOfHouse: String = "",
    @SerializedName("houseGhost")
    val houseGhost: String = "",
    @SerializedName("_id")
    val id: String = "",
    @SerializedName("mascot")
    val mascot: String = "",
    @SerializedName("name")
    val name: String = ""
  ): Serializable