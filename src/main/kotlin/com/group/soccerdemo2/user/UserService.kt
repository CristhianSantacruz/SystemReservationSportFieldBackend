package com.group.soccerdemo2.user

import com.group.soccerdemo2.exceptions.UserNotExits
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository): UserInterfaceService {
    override fun getUserById(userId: UUID): Optional<UserEntity> {
        val userOptional = userRepository.findById(userId)
        if(userOptional.isEmpty){throw UserNotExits()}
        return userOptional
    }

    override fun saveUser(userEntity: UserEntity) : UserEntity {
        return userRepository.save(userEntity)
    }

    override fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }

    override fun deleteUserById(userId: UUID): Boolean {
        val userOptional : Optional<UserEntity> = userRepository.findById(userId)
        if(userOptional.isPresent){
            userRepository.deleteById(userId)
            return true
        }
        return false

    }
}
