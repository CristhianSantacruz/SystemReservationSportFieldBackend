package com.group.soccerdemo2.sportField

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SportFieldRepository : JpaRepository<SportFieldEntity,Long> {
}