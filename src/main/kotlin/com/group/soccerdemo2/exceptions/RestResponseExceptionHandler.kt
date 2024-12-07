package com.group.soccerdemo2.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.RuntimeException

@RestControllerAdvice
class RestResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler()
    fun exceptionHandler(runtimeException: RuntimeException) : ResponseEntity<ErrorMessageDto> {
        val error = ErrorMessageDto(HttpStatus.NOT_FOUND,runtimeException.message!!)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }
}