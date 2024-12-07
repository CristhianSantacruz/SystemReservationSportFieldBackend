package com.group.soccerdemo2.sportField

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sportField")
class SportFieldController(private val iSportFieldService: ISportFieldService) {

    @GetMapping("/{id}")
    fun getSoccerByiId( @PathVariable id : Long): ResponseEntity<SportFieldEntity>{
        val sportField = iSportFieldService.getSportFieldById(id)
        return ResponseEntity.of(sportField)
    }
    @GetMapping("/all")
    fun getAllSoccer(): ResponseEntity<List<SportFieldEntity>>{
      return ResponseEntity.ok(iSportFieldService.getAllSports());
    }
    @PostMapping("/save")
    fun saveSoccerField(@RequestBody sportFieldEntity: SportFieldEntity){
        iSportFieldService.saveSportField(sportFieldEntity)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteSoccerById(@PathVariable id : Long): ResponseEntity<Boolean>{
        if (iSportFieldService.deleteSportFieldById(id)){
           return ResponseEntity.ok(true)
        }
        return ResponseEntity.ok(false)
    }
}