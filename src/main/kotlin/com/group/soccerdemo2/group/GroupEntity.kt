package com.group.soccerdemo2.group

import com.group.soccerdemo2.reservation.ReservationEntity
import com.group.soccerdemo2.user.UserEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "groups")
data class GroupEntity(
    @Id
    @field:GeneratedValue(strategy = GenerationType.UUID)
    val id : UUID?,
    @field:NotNull(message = "name is required") @NotBlank(message = "name is required")
    val name: String,
    @field:OneToMany(mappedBy = "group", cascade = [CascadeType.PERSIST,CascadeType.MERGE], fetch = FetchType.LAZY)
    val listUsers: MutableList<UserEntity> = mutableListOf(),
    @OneToMany(mappedBy = "group", cascade = [CascadeType.ALL], orphanRemoval = true)
    var reservations: MutableList<ReservationEntity> = mutableListOf()
)