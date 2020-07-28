package com.example.hogwarts_studentportal.networkUtilities.gson
import com.example.hogwarts_studentportal.networkUtilities.NetworkHelper
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.House
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Spell
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Student
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.jetbrains.anko.doAsync

/*  imports the Anko Library to gain access to doAsync Method, allowing me to avoid the
    coroutine boilerplate and just use the await/async functionality I need.
    Async is needed as HTTP requests cannot be sent from the Main Thread in Android  */

class GSONutility (){

    // instantiates an Gson object to access it's methods
    private var gson: Gson = Gson()

    //function that converts a Json object into a generic list of the House typeObject
    fun getHouses(): List<House>{
        var jsonHouses: JsonObject = JsonObject()

        //doAsync will asynchronously get the Json object using a NetworkHelper object
        doAsync { jsonHouses = NetworkHelper().getJsonObject("Houses") }

        //Gson generates a list of Houses from the JsonObject I received from the API
        val houses: List<House> = gson.fromJson(jsonHouses, listOf<House>().javaClass);
        return houses
    }

    //function that converts a Json object into a generic list of the Student typeObject
    fun getStudents(): List<Student> {
        var jsonStudents: JsonObject = JsonObject()

        //doAsync will asynchronously get the Json object using a NetworkHelper object
        doAsync { jsonStudents = NetworkHelper().getJsonObject("Houses") }

        //Gson generates a list of Students from the JsonObject I received from the API
        val students: List<Student> = gson.fromJson(jsonStudents, listOf<Student>().javaClass);
        return students
    }

    //function that converts a Json object into a generic list of the Spell typeObject
    fun getSpells(): List<Spell>{
        var jsonSpells: JsonObject = JsonObject()

        //doAsync will asynchronously get the Json object using a NetworkHelper object
        doAsync { jsonSpells = NetworkHelper().getJsonObject("Houses") }

        //Gson generates a list of Spells from the JsonObject I received from the API
        val spells: List<Spell> = gson.fromJson(jsonSpells, listOf<Spell>().javaClass);
        return spells
    }
}