package com.example.hogwarts_studentportal.networkUtilities.typeClasses

//typeObject for Spells with all necessary properties
class Spell(spell: String, type: String, effect: String) {

    private var spell: String? = null
    private var type: String? = null
    private var effect: String? = null

    init {
        this.spell = spell
        this.type = type
        this.effect = effect
    }
}