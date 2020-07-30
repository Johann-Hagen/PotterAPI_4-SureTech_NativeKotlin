package com.example.hogwarts_studentportal.networkUtilities.typeClasses

//typeObject for Spells with all necessary properties
class Spell(spell: String, type: String, effect: String) {

     var spell: String? = null
     var type: String? = null
     var effect: String? = null

    init {
        this.spell = spell
        this.type = type
        this.effect = effect
    }
}