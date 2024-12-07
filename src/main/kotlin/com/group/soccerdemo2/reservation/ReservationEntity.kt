package com.group.soccerdemo2.reservation

import com.group.soccerdemo2.group.GroupEntity
import com.group.soccerdemo2.sportField.SportFieldEntity
import com.group.soccerdemo2.user.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reservations")
data class ReservationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var localDateTimeReservation : LocalDateTime,
    @JoinColumn(name = "state")
    var reservationState: ReservationState,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(referencedColumnName = "id_group")
    var group: GroupEntity,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(referencedColumnName = "id_sportfield")
    var sportField : SportFieldEntity,

    )
