package com.group.soccerdemo2.sportField

import org.springframework.stereotype.Service
import java.util.*

@Service
class SportFieldService(
    private val soccerRepository: SportFieldRepository
) : ISportFieldService  {
    override fun getSportFieldById(id: Long): Optional<SportFieldEntity> {
        return soccerRepository.findById(id)
    }

    override fun getAllSports(): List<SportFieldEntity> {
        return soccerRepository.findAll()
    }

    override fun saveSportField(sportField: SportFieldEntity) {
       soccerRepository.save(sportField)
    }

    override fun deleteSportFieldById(id: Long): Boolean {
        val sportField = soccerRepository.findById(id)
        if(sportField.isPresent) {
            soccerRepository.delete(sportField.get())
            return true
        }
        return false
    }
}