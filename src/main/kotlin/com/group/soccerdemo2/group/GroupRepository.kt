package com.group.soccerdemo2.group

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
@Repository
interface GroupRepository : JpaRepository<GroupEntity , UUID> {
}