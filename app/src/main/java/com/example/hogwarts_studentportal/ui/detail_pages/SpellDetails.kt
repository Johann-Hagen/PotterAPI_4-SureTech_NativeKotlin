package com.example.hogwarts_studentportal.ui.detail_pages

import androidx.appcompat.app.AppCompatActivity
import com.example.hogwarts_studentportal.R
import android.os.Bundle
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Spell
import kotlinx.android.synthetic.main.activity_spelll_details.*

class SpellDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spelll_details)

        val bundle: Bundle? = intent.extras
        val spell: Spell = bundle!!.getSerializable("spell") as Spell

        txtSpellName.text = spell.spell
        txtSpellEffect.text = spell.effect
        txtSpellType.text = spell.type
    }
}