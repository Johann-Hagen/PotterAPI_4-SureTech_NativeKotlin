package com.example.hogwarts_studentportal.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.PotterAPIinterface
import com.example.hogwarts_studentportal.networkUtilities.model.House
import com.example.hogwarts_studentportal.networkUtilities.model.Spell
import com.example.hogwarts_studentportal.networkUtilities.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.longToast

class LoadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        val bundle: Bundle? = intent.extras
        val wizName = bundle!!.getString("userName")
        val pword = bundle.getString("password")
        var authorised: Boolean = false

        var students: ArrayList<Student> = ArrayList<Student>()
        var houses: ArrayList<House> = ArrayList<House>()
        var spells: ArrayList<Spell> = ArrayList<Spell>()
        val apiService = PotterAPIinterface

        GlobalScope.launch(Dispatchers.Main) {
            students = apiService.invoke().getAllStudents().await()
            spells = apiService.invoke().getAllSpells().await()
            houses = apiService.invoke().getAllHouses().await()

            for (Student in students){
                if (Student.name == wizName && Student.id == pword){
                    authorised = true
                }
            }
            if (authorised){
                val intent = Intent(this@LoadingScreen, Home_Page::class.java)
                intent.putExtra("students", students)
                intent.putExtra("spells", spells)
                intent.putExtra("houses", houses)
                startActivity(intent)
            }else{
                val intent = Intent(this@LoadingScreen, MainActivity::class.java)
                startActivity(intent)
                longToast("Invalid Credentials")
            }


        }


    }
}