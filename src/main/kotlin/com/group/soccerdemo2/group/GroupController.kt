package com.group.soccerdemo2.group

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/groups")
class GroupController(private val iGroupService: IGroupService) {

    @GetMapping("/hello", produces = ["text/plain"])
    fun helloController():String = "Hello , I am group Controller"

    @GetMapping("/{id}")
    fun getGroupById(@PathVariable(value = "id") groupId: UUID): ResponseEntity<GroupEntity> {
        val group = iGroupService.getGroupById(groupId)
        return when (group.isPresent) {
            true -> ResponseEntity.ok(group.get())
            false -> ResponseEntity.notFound().build()
        }
    }
    @GetMapping("/all")
    fun getAllGroups() : ResponseEntity<List<GroupEntity>> = ResponseEntity.ok(iGroupService.getAllGroups())

    @PostMapping("/add/{idGroup}/user/{idUser}")
    fun addUserToGroup(@PathVariable idGroup: UUID, @PathVariable idUser: UUID): ResponseEntity<Boolean> {
        return when (iGroupService.addUserEntityToGroup(idUser,idGroup)) {
            false -> ResponseEntity.notFound().build()
            true -> ResponseEntity.ok(true)
        }
    }

    @DeleteMapping("/delete/{idGroup}/user/{idUser}")
    fun deleteUserToGroup(@PathVariable idGroup: UUID, @PathVariable idUser: UUID): ResponseEntity<Boolean> {
        return when (iGroupService.deleteUserEntityToGroup(idUser,idGroup)) {
            false -> ResponseEntity.notFound().build()
            true -> ResponseEntity.ok(true)
        }
    }
    @PostMapping("/create/{idOwnerUser}")
    fun createGroup( @RequestBody @Valid group: @Valid GroupEntity, @PathVariable idOwnerUser : UUID): ResponseEntity<GroupEntity> {
        val groupCreate = iGroupService.createGroup(group,idOwnerUser)
        return ResponseEntity.status(201).body(groupCreate)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteGroup(@PathVariable(value = "id") groupId: UUID): ResponseEntity<Boolean> {
        return when (iGroupService.deleteGroupById(groupId)) {
            false -> ResponseEntity.notFound().build()
            true -> ResponseEntity.ok(true)
        }
    }


}