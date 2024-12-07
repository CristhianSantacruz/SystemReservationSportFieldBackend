package com.group.soccerdemo2.reservation

import java.util.Optional

interface IReservationService {

    fun getReservationById(id : Long) : Optional<ReservationEntity>
    fun getAllReservations(): List<ReservationEntity>
    fun getAllReservationsByState(state: String) : List<ReservationEntity>
    fun createReservation(reservation : ReservationEntity) : ReservationEntity
    fun updateReservation(id: Long,reservation : ReservationEntity) : ReservationEntity
    fun deleteReservationById(id : Long) : Boolean
}