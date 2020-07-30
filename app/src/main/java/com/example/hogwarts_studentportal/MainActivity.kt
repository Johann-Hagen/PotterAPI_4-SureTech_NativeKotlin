package com.example.hogwarts_studentportal


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener(){
            if (txtUsername.text != null && txtPassword.text != null){
                startActivity(Intent(this, Home_Page::class.java))
            }
        }



    }

}