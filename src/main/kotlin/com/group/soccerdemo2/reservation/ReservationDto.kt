package com.group.soccerdemo2.reservation

import java.util.UUID

data class ReservationDto(
    val state : String,
    val groupId : UUID,
    val sportFieldId : Long,
)
