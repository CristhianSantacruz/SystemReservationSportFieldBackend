package com.group.soccerdemo2.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.group.soccerdemo2.group.GroupEntity
import jakarta.persistence.*

import jakarta.validation.constraints.*
import java.util.*
@Entity
@Table(name = "users")

data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,
    @field:NotBlank(message = "name is required")
    val name: String,
    val lastName : String,
    @field:NotNull(message = "dni not null") @field:NotBlank(message = "dni is required")
    val dni : String,
    val phone : String,
    @field:NotNull(message = "email is required") @field:NotBlank(message = "email is required") @field:Email(message = "this email not is correct")
    val email : String,
    var isOwner : Boolean = false,
    @field:ManyToOne(targetEntity = GroupEntity::class, fetch = FetchType.LAZY, optional = true)
    @field:JoinColumn(name="group_id")
    @field:JsonIgnore
    var group : GroupEntity? = null
)
