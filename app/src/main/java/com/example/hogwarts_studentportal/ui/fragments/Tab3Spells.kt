package com.example.hogwarts_studentportal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.model.Spell
import com.example.hogwarts_studentportal.recyclerViewUtilities.SpellRecyclerAdapter


class Tab3Spells(val spells: ArrayList<Spell>) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var spellAdapter: SpellRecyclerAdapter? = null

    private var recycler: RecyclerView.LayoutManager? = null
    private val mySpellRecycler: RecyclerView? = null;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myStudentRecycler = view.findViewById<RecyclerView>(R.id.mySpellRecycler)
        recycler = LinearLayoutManager(context)
        spellAdapter = SpellRecyclerAdapter(spells, context!!)
        myStudentRecycler?.layoutManager = recycler
        myStudentRecycler?.adapter = spellAdapter
        spellAdapter!!.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab3__spells, container, false)
    }
}