package com.example.hogwarts_studentportal.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.model.House
import com.example.hogwarts_studentportal.networkUtilities.model.Spell
import com.example.hogwarts_studentportal.networkUtilities.model.Student
import com.example.hogwarts_studentportal.ui.adapters.Pager2Adapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home__page.*

class Home_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__page)

        val bundle: Bundle? = intent.extras
        val students = bundle!!.get("students") as ArrayList<Student>
        val houses = bundle.get("houses") as ArrayList<House>
        val spells = bundle.get("spells") as ArrayList<Spell>

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = Pager2Adapter(this, houses, students, spells)

        val tabLayoutMediator: TabLayoutMediator = TabLayoutMediator(tabLayout, viewPager2, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when(position){
                0->{tab.text = "houses"}
                1->{tab.text = "students"}
                2->{tab.text = "spells"}
                3->{tab.text = "favourites"}
            }
        })
        tabLayoutMediator.attach()
    }

}