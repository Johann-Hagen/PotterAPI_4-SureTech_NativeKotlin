package com.example.hogwarts_studentportal.recyclerViewUtilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwarts_studentportal.R
import com.example.hogwarts_studentportal.networkUtilities.typeClasses.Spell

class SpellRecyclerAdapter (private val spells: List<Spell>,
                            private val context: Context
) : RecyclerView.Adapter<SpellRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(spell: Spell){
            val nameView: TextView = itemView.findViewById(R.id.spellCardName) as TextView
            val ageView: TextView = itemView.findViewById(R.id.spellCardType) as TextView

            nameView.text = spell.spell
            ageView.text = spell.type
        }
    }
    override fun onBindViewHolder(holder: SpellRecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItem(spells[position])
    }
    override fun getItemCount(): Int {
        return spells.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): SpellRecyclerAdapter.ViewHolder {
        // our view from our XML
        val view = LayoutInflater.from(context).inflate(R.layout.spell_card, parent,false)
        return ViewHolder(view)
    }
}