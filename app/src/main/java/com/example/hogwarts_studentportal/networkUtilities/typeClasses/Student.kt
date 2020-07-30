package com.example.hogwarts_studentportal.networkUtilities.typeClasses

//typeObject for Hogwarts Students with all necessary properties
class Student(id: String, name: String, house: String, ministryOfMagic: Boolean, orderOfThePhoenix: Boolean, dumbledoresArmy: Boolean, deathEater: Boolean, bloodStatus: String){

     var id: String? = null
     var name: String? = null
     var house: String? = null
     var ministryOfMagic: Boolean? = null
     var orderOfThePhoenix: Boolean? = null
     var dumbledoresArmy: Boolean? = null
     var deathEater: Boolean? = null
     var bloodStatus: String? = null;

    init {
        this.id = id
        this.name = name
        this.house = house
        this.ministryOfMagic = ministryOfMagic
        this.orderOfThePhoenix = orderOfThePhoenix
        this.dumbledoresArmy = dumbledoresArmy
        this.deathEater = deathEater
        this.bloodStatus = bloodStatus
    }
}
