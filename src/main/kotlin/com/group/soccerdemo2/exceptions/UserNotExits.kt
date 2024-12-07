package com.group.soccerdemo2.exceptions

class UserNotExits(message : String = "El usuario no existe") : RuntimeException(message) {
}