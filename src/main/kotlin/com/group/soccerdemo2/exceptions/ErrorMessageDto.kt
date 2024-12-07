package com.group.soccerdemo2.exceptions

import org.springframework.http.HttpStatus

data class ErrorMessageDto(
    val httpStatus: HttpStatus,
    val message : String,
)
