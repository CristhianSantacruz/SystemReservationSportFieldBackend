package com.group.soccerdemo2.group

import com.group.soccerdemo2.exceptions.GroupNotExits
import com.group.soccerdemo2.exceptions.MoreTenUsersException
import com.group.soccerdemo2.exceptions.UserAlreadyOwner
import com.group.soccerdemo2.exceptions.UserNotExits
import com.group.soccerdemo2.user.UserRepository
import com.group.soccerdemo2.user.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class GroupService(
    private val groupRepository: GroupRepository,
    private val userService: UserService,
    private val userRepository: UserRepository
)  : IGroupService {
    override fun getGroupById(id: UUID): Optional<GroupEntity> {
        val groupOptional = groupRepository.findById(id)
        if (groupOptional.isEmpty) throw  GroupNotExits()
        return groupOptional
    }

    override fun getAllGroups(): List<GroupEntity> {
        return groupRepository.findAll()
    }

    override fun createGroup(group: GroupEntity,idOwnerUser : UUID): GroupEntity {
        val ownerUser = userService.getUserById(idOwnerUser)
            .orElseThrow { UserNotExits() }

        if(ownerUser.isOwner) throw UserAlreadyOwner()
        group.listUsers.add(ownerUser)
        val groupSaved = groupRepository.save(group)
        ownerUser.group = groupSaved
        ownerUser.isOwner = true
        userService.saveUser(ownerUser)
        return groupSaved
    }

    override fun deleteGroupById(id: UUID): Boolean {
        val groupOptional = groupRepository.findById(id)
        if(groupOptional.isPresent){
            groupRepository.deleteById(id)
            return true
        }
        return false;
    }

    override fun addUserEntityToGroup(idUser: UUID, idGroup: UUID): Boolean {
        //verificar que exista el grupo
        //verificar que exista el usuario
        //verificar que el grupo no se mayor de 10
        val groupOptional = groupRepository.findById(idGroup)
        if(groupOptional.isEmpty) throw GroupNotExits()
        val userOptional = userService.getUserById(idUser)
        val group = groupOptional.get()
        val user = userOptional.get()

        if (group.listUsers.size >= 10) {
            throw MoreTenUsersException()
        }
        group.listUsers.add(user)
        user.group = group
        groupRepository.save(group)
        userRepository.save(user)
        return true

    }

    override fun deleteUserEntityToGroup(idUser: UUID, idGroup: UUID): Boolean {
        val groupOptional = groupRepository.findById(idGroup)
        if(groupOptional.isEmpty) return false

        val userOptional = userService.getUserById(idUser)
        if(userOptional.isEmpty) return false

        val group = groupOptional.get()
        group.listUsers.remove(userOptional.get())
        return true
    }
}