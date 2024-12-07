package com.group.soccerdemo2.reservation

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<ReservationEntity,Long> {

    fun getAllByReservationState(state: ReservationState) : List<ReservationEntity>
}