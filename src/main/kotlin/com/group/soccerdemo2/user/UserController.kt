package com.group.soccerdemo2.user


import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserInterfaceService) {

    @GetMapping("/hello", produces = ["text/plain"])
    fun hello() : String = "Hello World!";

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: UUID): ResponseEntity<UserEntity> {
        val userOptional = userService.getUserById(id);
        if(userOptional.isPresent) {
            return ResponseEntity.ok(userOptional.get())
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<UserEntity>>  = ResponseEntity.ok(userService.getAllUsers())

    @PostMapping("/save")
    fun saveUser( @RequestBody @Valid userEntity:  UserEntity): ResponseEntity<UserEntity> {
        val user : UserEntity = userService.saveUser(userEntity)
        return ResponseEntity.status(201).body(user);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Boolean> {
        val userOptional = userService.getUserById(id);
        if(userOptional.isPresent) {
            return ResponseEntity.ok(userService.deleteUserById(id));
        }
        return ResponseEntity.notFound().build();
    }

}