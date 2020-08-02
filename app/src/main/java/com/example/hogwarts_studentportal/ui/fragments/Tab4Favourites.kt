package com.example.hogwarts_studentportal.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.model.Spell
import com.example.hogwarts_studentportal.recyclerViewUtilities.SpellRecyclerAdapter
import com.example.hogwarts_studentportal.room.FavDB
import com.example.hogwarts_studentportal.room.Favourite
import kotlinx.coroutines.*
import org.jetbrains.anko.doAsync



class Tab4Favourites(private val spells: ArrayList<Spell>) : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var spellAdapter: SpellRecyclerAdapter? = null
    private var recycler: RecyclerView.LayoutManager? = null

     private fun refresh(){
         val myStudentRecycler = view!!.findViewById<RecyclerView>(R.id.mySpellRecycler)
         var favs: ArrayList<Favourite> = ArrayList<Favourite>()
         val faveSpells: ArrayList<Spell> = ArrayList<Spell>()
        CoroutineScope(Dispatchers.Main).launch {
            favs = getFaves()
            for (Spell in spells) {
                for (Favourite in favs) {
                    if (Spell.id == Favourite.id && Favourite.isFavourite) {
                        Spell.favourite = true
                        faveSpells.add(Spell)
                    }
                }
            }
            recycler = LinearLayoutManager(context)
            spellAdapter = SpellRecyclerAdapter(faveSpells, context!!)
            myStudentRecycler?.layoutManager = recycler
            myStudentRecycler?.adapter = spellAdapter
            spellAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        refresh()
    }

    suspend fun getFaves(): ArrayList<Favourite> = withContext(Dispatchers.Main) {
        var favs: List<Favourite>? = null
        val favarraylist = ArrayList<Favourite>()
        doAsync {
            favs = FavDB.get(activity!!.application).getFavouriteDAO().getFavs()
            for (Favourite in favs!!){
                favarraylist.add(Favourite)
            }
        }
      delay(100)
        favarraylist
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab4__favourites, container, false)
    }


}