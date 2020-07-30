package com.example.hogwarts_studentportal.recyclerViewUtilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hogwarts_studentportal.R
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Student

class StudentRecyclerAdapter (private val students: List<Student>,
private val context: Context
) : RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(student: Student){
            val nameView: TextView = itemView.findViewById(R.id.studCardName) as TextView
            val ageView: TextView = itemView.findViewById(R.id.studCardHouse) as TextView

            nameView.text = student.name
            ageView.text = student.house
        }
    }
    override fun onBindViewHolder(holder: StudentRecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItem(students[position])
    }
    override fun getItemCount(): Int {
        return students.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): StudentRecyclerAdapter.ViewHolder {
        // our view from our XML
        val view = LayoutInflater.from(context).inflate(R.layout.student_card, parent,false)
        return ViewHolder(view)
    }
}