package com.example.hogwarts_studentportal.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Favourite (
    @PrimaryKey
    var id: String,
    var isFavourite: Boolean
)