package com.example.hogwarts_studentportal.ui.detail_pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.model.House
import com.example.hogwarts_studentportal.networkUtilities.model.Student
import com.example.hogwarts_studentportal.recyclerViewUtilities.StudentRecyclerAdapter


class HouseDetails( ) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_details)

        val bundle: Bundle? = intent.extras
        val house: House = bundle!!.getSerializable("house") as House
        val studentList: ArrayList<Student> = bundle.getSerializable("students") as ArrayList<Student>
        val image: ImageView = findViewById<ImageView>(R.id.houseImage)
        val founder: TextView = findViewById<TextView>(R.id.txtFounder)
        val head: TextView = findViewById<TextView>(R.id.txtHead)
        val ghost: TextView = findViewById<TextView>(R.id.txtGhost)
        val mascot: TextView = findViewById<TextView>(R.id.txtMascot)
        val houseName: TextView = findViewById<TextView>(R.id.txtHouseName)

        founder.text = house.founder
        head.text = house.headOfHouse
        ghost.text = house.houseGhost
        mascot.text = house.mascot
        houseName.text = house.name

        when(house.name){
            "Gryffindor"->{
                image.setImageResource(R.drawable.gryffindor)}
            "Hufflepuff"->{
                image.setImageResource(R.drawable.hufflepuff)}
            "Slytherin"->{
                image.setImageResource(R.drawable.slytherin)}
            "Ravenclaw"->{
                image.setImageResource(R.drawable.ravenclaw)}
        }
        var studentAdapter: StudentRecyclerAdapter? = null
        var recycler: RecyclerView.LayoutManager? = null
        var myStudentRecycler: RecyclerView? = null;
        myStudentRecycler = findViewById<RecyclerView>(R.id.houseStudentRecyclerView)
        recycler = LinearLayoutManager(this)
        studentAdapter = StudentRecyclerAdapter(studentList, this)
        myStudentRecycler?.layoutManager = recycler
        myStudentRecycler?.adapter = studentAdapter
        studentAdapter.notifyDataSetChanged()
    }
}