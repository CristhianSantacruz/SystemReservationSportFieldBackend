package com.group.soccerdemo2.exceptions

class MoreTenUsersException(message : String = "El grupo ya contiene 10 usuarios. No se pueden añadir más.") :RuntimeException(message) {
}