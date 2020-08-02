package com.example.hogwarts_studentportal.ui.main


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hogwarts_studentportal.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener(){
            if (txtUsername.text != null && txtPassword.text != null){
                if (txtPassword.text.toString() == "Password"){
                    longToast("Enter Wizard Name and Password!")
                }else{
                    val intent = Intent(this, LoadingScreen::class.java)
                    intent.putExtra("userName", txtUsername.text.toString())
                    intent.putExtra("password", txtPassword.text.toString())
                    startActivity(intent)
                }
            }
        }
    }
}