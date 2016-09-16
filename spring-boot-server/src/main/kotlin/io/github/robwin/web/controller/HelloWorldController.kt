package io.github.robwin.web.controller

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Component
class HelloWorldController() {

    @GetMapping(value = "/test")
    fun hello() = "Hello World"
}