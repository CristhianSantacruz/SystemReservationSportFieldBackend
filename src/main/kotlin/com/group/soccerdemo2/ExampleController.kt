package com.group.soccerdemo2

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {

    @GetMapping("/hello")
    fun helloByName(@RequestParam("name") name:String) :
            ResponseEntity<String> = ResponseEntity.ok("Hello, $name");
}