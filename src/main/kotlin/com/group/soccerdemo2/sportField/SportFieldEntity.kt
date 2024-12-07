package com.group.soccerdemo2.sportField

import com.group.soccerdemo2.reservation.ReservationEntity
import jakarta.persistence.*

@Entity
@Table(name = "sportfield")
data class SportFieldEntity (
   @Id @GeneratedValue(strategy = GenerationType.AUTO)
   val id: Long?,
   val name: String,
   val description: String,

   @OneToMany(mappedBy = "sportField", cascade = [CascadeType.ALL], orphanRemoval = true)
   var reservations:MutableList<ReservationEntity> = mutableListOf()
)