package com.example.hogwarts_studentportal.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.model.Student
import com.example.hogwarts_studentportal.recyclerViewUtilities.StudentRecyclerAdapter

class Tab2Students(private val students: ArrayList<Student>) : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var studentAdapter: StudentRecyclerAdapter? = null
    private var recycler: RecyclerView.LayoutManager? = null
    private val myStudentRecycler: RecyclerView? = null;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myStudentRecycler = view.findViewById<RecyclerView>(R.id.myStudRecycler)
            recycler = LinearLayoutManager(context)
            studentAdapter = StudentRecyclerAdapter(students, context!!)
            myStudentRecycler?.layoutManager = recycler
            myStudentRecycler?.adapter = studentAdapter
            studentAdapter!!.notifyDataSetChanged()
         }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2__students, container, false)
    }
}