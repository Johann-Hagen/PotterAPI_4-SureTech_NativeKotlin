package com.example.hogwarts_studentportal.networkUtilities.typeClasses

//typeObject for Hogwarts Students with all necessary properties
class Student(id: String, name: String, house: String, ministryOfMagic: Boolean, orderOfThePhoenix: Boolean, dumbledoresArmy: Boolean, deathEater: Boolean, bloodStatus: String){

    private var id: String? = null
    private var name: String? = null
    private var house: String? = null
    private var ministryOfMagic: Boolean? = null
    private var orderOfThePhoenix: Boolean? = null
    private var dumbledoresArmy: Boolean? = null
    private var deathEater: Boolean? = null
    private var bloodStatus: String? = null;

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
