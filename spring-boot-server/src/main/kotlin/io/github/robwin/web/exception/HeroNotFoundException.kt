package io.github.robwin.web.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class HeroNotFoundException(message: String?) : RuntimeException(message)
