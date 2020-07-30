package com.example.hogwarts_studentportal

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.hogwarts_studentportal.ui.main.Pager2Adapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home__page.*

class Home_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__page)

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = Pager2Adapter(this)

        val tabber: TabLayout = findViewById(R.id.tabLayout)
        val tabLayoutMediator: TabLayoutMediator = TabLayoutMediator(tabLayout, viewPager2, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when(position){
                0->{
                    tab.text = "houses"
                }
                1->{
                    tab.text = "students"
                }
                2->{
                    tab.text = "spells"
                }
                3->{
                    tab.text = "favourites"
                }
            }
        })
        tabLayoutMediator.attach()
    }

}