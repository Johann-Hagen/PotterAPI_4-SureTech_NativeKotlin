package com.example.hogwarts_studentportal.ui.detail_pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Student
import kotlinx.android.synthetic.main.activity_student_details.*

class StudentDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        val bundle: Bundle? = intent.extras
        val student: Student = bundle!!.getSerializable("student") as Student

        txtStudentName.text = student.name
        txtStudentBlood.text = student.bloodStatus
        txtStudentHouse.text = student.house
        txtStudentRole.text = student.role
        txtStudentSpecies.text = student.species

    }
}