package com.example.hogwarts_studentportal.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavouriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFav(spell: Favourite)

    @Query("SELECT * FROM Favourite")
    fun getFavs(): List<Favourite>

    @Query("DELETE FROM Favourite WHERE Favourite.id = :id")
    fun deleteFav(id: String)
}