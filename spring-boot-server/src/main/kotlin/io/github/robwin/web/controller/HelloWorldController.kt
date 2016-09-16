package io.github.robwin.web.controller

import io.github.robwin.web.dto.HelloWorldResponse
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Component
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class HelloWorldController() {

    @GetMapping(value = "/test")
    fun hello() = HelloWorldResponse("Hello World")
}
