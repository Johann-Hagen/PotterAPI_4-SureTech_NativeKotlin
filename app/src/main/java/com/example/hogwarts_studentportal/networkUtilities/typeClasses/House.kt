package com.example.hogwarts_studentportal.networkUtilities.typeClasses

//typeObject for Hogwarts houses with all necessary properties
class House(name: String,  mascot: String, headOfHouse: String, houseGhost: String, founder: String){

     private var name: String? = null
     private var mascot: String? = null
     private var headOfHouse: String? = null
     private var houseGhost: String? = null
     private var founder: String? = null

     init {
         this.name = name
          this.mascot = mascot
          this.headOfHouse = headOfHouse
          this.houseGhost = houseGhost
          this.founder = founder
     }
}

