package com.example.hogwarts_studentportal.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Favourite::class], exportSchema = false)
abstract class FavDB(): RoomDatabase() {
    companion object{
        fun get(application: Application): FavDB{
            return Room.databaseBuilder(application, FavDB::class.java, "Favourites")
                .build()
        }
    }
    abstract fun getFavouriteDAO(): FavouriteDAO
}