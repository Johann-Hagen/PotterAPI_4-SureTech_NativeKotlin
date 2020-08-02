package com.example.hogwarts_studentportal

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Spell
import com.example.hogwarts_studentportal.recyclerViewUtilities.SpellRecyclerAdapter
import com.example.hogwarts_studentportal.room.FavDB
import com.example.hogwarts_studentportal.room.Favourite
import com.example.hogwarts_studentportal.room.FavouriteDAO
import kotlinx.coroutines.*
import org.jetbrains.anko.doAsync


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [Tab4_Favourites.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tab4_Favourites(var spells: ArrayList<Spell>) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var spellAdapter: SpellRecyclerAdapter? = null
    private var recycler: RecyclerView.LayoutManager? = null
    private val mySpellRecycler: RecyclerView? = null;
    private var thisContext: Context? = null
    private val myStudentRecycler: RecyclerView? = null


     fun refresh(){

        Log.d("resume", "resumed")
         val myStudentRecycler = view!!.findViewById<RecyclerView>(R.id.mySpellRecycler)
        var favs: ArrayList<Favourite> = ArrayList<Favourite>()
        var faveSpells: ArrayList<Spell> = ArrayList<Spell>()
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
        thisContext = context
        val myStudentRecycler = view.findViewById<RecyclerView>(R.id.mySpellRecycler)
        var favs: ArrayList<Favourite> = ArrayList<Favourite>()
        var faveSpells: ArrayList<Spell> = ArrayList<Spell>()
        CoroutineScope(Dispatchers.Main).launch {
            favs = getFaves()
            for(Spell in spells){
                for (Favourite in favs){
                    if (Spell.id == Favourite.id && Favourite.isFavourite){
                        Spell.favourite = true
                        faveSpells.add(Spell)
                    }
                }
            }
            Log.d("after loop", "${faveSpells.size}")
            recycler = LinearLayoutManager(context)
            spellAdapter = SpellRecyclerAdapter(faveSpells, context!!)
            myStudentRecycler?.layoutManager = recycler
            myStudentRecycler?.adapter = spellAdapter
            spellAdapter!!.notifyDataSetChanged()
        }


    }
    suspend fun getFaves(): ArrayList<Favourite> = withContext(Dispatchers.Main) {
        var favs: List<Favourite>? = null
        val favarraylist = ArrayList<Favourite>()
        doAsync {
            favs = FavDB.get(activity!!.application).getFavouriteDAO().getFavs()
            Log.d("Yeeeeee", "${favs?.size} Yeeeee")
            for (Favourite in favs!!){
                favarraylist.add(Favourite)
            }
        }
      delay(100)

        favarraylist
    }



    companion object{
        fun refresh() {

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
        return inflater.inflate(R.layout.fragment_tab4__favourites, container, false)
    }


}