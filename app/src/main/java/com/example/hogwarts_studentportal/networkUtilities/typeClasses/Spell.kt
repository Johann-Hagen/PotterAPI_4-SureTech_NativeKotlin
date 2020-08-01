package com.example.hogwarts_studentportal.networkUtilities.typeClasses


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Spell(
    @SerializedName("effect")
    val effect: String = "",
    @SerializedName("_id")
    val id: String = "",
    @SerializedName("spell")
    val spell: String = "",
    @SerializedName("type")
    val type: String = "",
    val favourite: Boolean = false

): Serializable




