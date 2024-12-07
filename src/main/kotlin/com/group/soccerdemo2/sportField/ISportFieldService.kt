package com.group.soccerdemo2.sportField

import java.util.*

interface ISportFieldService {

    fun getSportFieldById(id:Long) : Optional<SportFieldEntity>
    fun getAllSports() : List<SportFieldEntity>
    fun saveSportField(sportField: SportFieldEntity)
    fun deleteSportFieldById(id:Long) : Boolean
}