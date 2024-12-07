package com.group.soccerdemo2.reservation

import com.group.soccerdemo2.exceptions.EntityNotExits
import com.group.soccerdemo2.group.GroupService
import com.group.soccerdemo2.sportField.ISportFieldService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
@Service
class ReservationService(private val reservationRepository: ReservationRepository,private val groupService: GroupService,private val sportFieldService: ISportFieldService,) : IReservationService{
    override fun getReservationById(id: Long): Optional<ReservationEntity> {
        return reservationRepository.findById(id)
    }

    override fun getAllReservations(): List<ReservationEntity> {
        return reservationRepository.findAll()
    }

    override fun getAllReservationsByState(state: String): List<ReservationEntity> {
        val reservationState : ReservationState = enumValueOf<ReservationState>(state);
        return reservationRepository.getAllByReservationState(reservationState)
    }

    override fun createReservation(reservation: ReservationEntity): ReservationEntity {
        val localDateTime = LocalDateTime.now()
        reservation.reservationState = ReservationState.Available
        reservation.localDateTimeReservation = localDateTime
        return reservationRepository.save(reservation)
    }

    override fun updateReservation(id: Long, reservationDto: ReservationDto): ReservationEntity {
        if(!reservationRepository.existsById(id)){
            throw EntityNotExits("La reserva si existe")

        }

        //buscar grupo
        val newGroup = groupService.getGroupById(reservationDto.groupId)
        if(newGroup.isEmpty){throw  EntityNotExits("El grupo no existe")}


        //buscar cancha
        val newSportField = sportFieldService.getSportFieldById(reservationDto.sportFieldId)
        if(newSportField.isEmpty){throw EntityNotExits("La cancha no existe")}

        val newDataReservation = ReservationEntity(
            id = id,
            localDateTimeReservation = LocalDateTime.now(),
            reservationState = enumValueOf<ReservationState>(reservationDto.state),
            group = newGroup.get(),
            sportField = newSportField.get()
        )
        return reservationRepository.save(newDataReservation);
    }

    override fun deleteReservationById(id: Long): Boolean {
        if(reservationRepository.existsById(id)){
            reservationRepository.deleteById(id)
            return true
        }
        return false
    }
}