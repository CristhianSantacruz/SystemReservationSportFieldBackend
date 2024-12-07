package com.group.soccerdemo2.user

import java.util.*

interface UserInterfaceService {

    fun getUserById(userId: UUID): Optional<UserEntity>
    fun saveUser(userEntity: UserEntity) : UserEntity
    fun getAllUsers(): List<UserEntity>
    fun deleteUserById(userId: UUID): Boolean
}