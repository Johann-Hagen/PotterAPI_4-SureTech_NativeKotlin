package com.example.hogwarts_studentportal.ui.detail_pages

import androidx.appcompat.app.AppCompatActivity
import com.example.hogwarts_studentportal.R
import android.os.Bundle
import android.util.Log
import com.example.hogwarts_studentportal.networkUtilities.model.Spell
import com.example.hogwarts_studentportal.room.FavDB
import com.example.hogwarts_studentportal.room.Favourite
import kotlinx.android.synthetic.main.activity_spelll_details.*
import kotlinx.coroutines.*
import org.jetbrains.anko.doAsync

class SpellDetails : AppCompatActivity() {

    suspend  fun addSpell(spell: Spell) = withContext(Dispatchers.Main){
        doAsync {  FavDB.get(application).getFavouriteDAO().insertFav(Favourite(spell.id, spell.favourite))
            val favs: List<Favourite> = FavDB.get(application).getFavouriteDAO().getFavs()
        }
    }
    suspend  fun removeSpell(spell: Spell) = withContext(Dispatchers.Main){
        doAsync { FavDB.get(application).getFavouriteDAO().deleteFav(spell.id)
            val favs: List<Favourite> = FavDB.get(application).getFavouriteDAO().getFavs()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spelll_details)

        val bundle: Bundle? = intent.extras
        val spell: Spell = bundle!!.getSerializable("spell") as Spell

        txtSpellName.text = spell.spell
        txtSpellEffect.text = spell.effect
        txtSpellType.text = spell.type
        favSwitch.isChecked = spell.favourite
        favSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (!isChecked) {
                favSwitch.isChecked = false
                spell.favourite = false
                CoroutineScope(Dispatchers.Main).launch {
                    removeSpell(spell)
                }
            }
            if (isChecked) {
                favSwitch.isChecked = true
                spell.favourite = true
                CoroutineScope(Dispatchers.Main).launch {
                    addSpell(spell)
                }
            }
        }
    }
}