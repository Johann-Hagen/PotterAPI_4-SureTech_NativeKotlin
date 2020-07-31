package com.example.hogwarts_studentportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.longToast

class LoadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        val bundle: Bundle? = intent.extras
        val wizName = bundle!!.getString("userName")
        val pword = bundle!!.getString("password")

        longToast("$wizName")
    }
}