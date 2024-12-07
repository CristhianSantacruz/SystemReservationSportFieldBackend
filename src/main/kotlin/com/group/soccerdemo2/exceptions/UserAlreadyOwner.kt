package com.group.soccerdemo2.exceptions

import java.lang.RuntimeException

class UserAlreadyOwner(message : String = "El usuario ya es dueño de un grupo") : RuntimeException(message) {
}