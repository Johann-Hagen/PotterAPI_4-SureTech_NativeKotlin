package com.example.hogwarts_studentportal.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.House
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.StudentList
import com.example.hogwarts_studentportal.ui.detail_pages.HouseDetails
import kotlinx.android.synthetic.main.fragment_tab1__houses.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tab1_Houses.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tab1_Houses(
    private val houses: ArrayList<House>, private val studentList: StudentList
) : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fun houseFilter(name: String): House{
            var sortHouse: House = House()
            for (House in houses){
                if (House.name == name){
                    sortHouse = House
                }
            }
            return sortHouse
        }
        fun studentFilter(house: String, studlist: StudentList): StudentList{
            val sortList: StudentList = StudentList()
            for (Student in studlist){
                if (Student.house == house){
                    sortList.add(Student)
                }
            }
            return sortList
        }
        gryfButton.setOnClickListener(){
            val gryfHouse: House = houseFilter("Gryffindor")
            val gryStudents = studentFilter("Gryffindor", studentList)
            val intent: Intent = Intent(this.context, HouseDetails::class.java)
            intent.putExtra("house", gryfHouse)
            intent.putExtra("students", gryStudents)
            startActivity(intent)
        }
        huffButton.setOnClickListener(){
            val huffHouse: House = houseFilter("Hufflepuff")
            val huffStudents = studentFilter("Hufflepuff", studentList)
            val intent: Intent = Intent(this.context, HouseDetails::class.java)
            intent.putExtra("house", huffHouse)
            intent.putExtra("students", huffStudents)
            startActivity(intent)
        }
        slythButton.setOnClickListener(){
            val slyHouse: House = houseFilter("Slytherin")
            val slyStudents = studentFilter("Slytherin", studentList)
            val intent: Intent = Intent(this.context, HouseDetails::class.java)
            intent.putExtra("house", slyHouse)
            intent.putExtra("students", slyStudents)
            startActivity(intent)
        }
        ravButton.setOnClickListener(){
            val ravHouse: House = houseFilter("Ravenclaw")
            val ravStudents = studentFilter("Ravenclaw", studentList)
            val intent: Intent = Intent(this.context, HouseDetails::class.java)
            intent.putExtra("house", ravHouse)
            intent.putExtra("students", ravStudents)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_tab1__houses, container, false)
    }


}