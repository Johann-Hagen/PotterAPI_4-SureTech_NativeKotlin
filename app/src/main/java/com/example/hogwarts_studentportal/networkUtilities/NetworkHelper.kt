package com.example.hogwarts_studentportal.networkUtilities
import com.google.gson.JsonObject
import java.net.URL

// API key
const val kApiKey: String = "$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y"

//Class that handles direct communication with the potterAPI
class NetworkHelper() {

    //Function that will send http GET request to the API to retrieve JSON objects
    fun getJsonObject(query: String) : JsonObject{
        //returns the Json syntax in String format
        val jsonobj = URL("https://www.potterapi.com/v1/$query?key=$kApiKey").readText()
        //converts the string into a JsonObject
        return JsonObject().getAsJsonObject(jsonobj)
    }
}