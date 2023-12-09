package org.adaschool.proyectoReservas.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.adaschool.proyectoReservas.application.lasting.EStateReservation;

import java.sql.Time;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDto(
        Integer id,
        Date bookingDate,
        Time bookingHour,
        String description,
        EStateReservation stateReservation,
        UserDto userDto
) {                                         }
