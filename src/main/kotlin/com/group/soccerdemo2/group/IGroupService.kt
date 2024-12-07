package com.group.soccerdemo2.group

import java.util.*

interface IGroupService {

    fun getGroupById(id:UUID): Optional<GroupEntity>
    fun getAllGroups() : List<GroupEntity>
    fun createGroup(group: GroupEntity,idOwnerUser : UUID): GroupEntity
    fun deleteGroupById(id: UUID): Boolean
    fun addUserEntityToGroup(idUser:UUID,idGroup:UUID): Boolean
    fun deleteUserEntityToGroup(idUser:UUID,idGroup: UUID): Boolean
}