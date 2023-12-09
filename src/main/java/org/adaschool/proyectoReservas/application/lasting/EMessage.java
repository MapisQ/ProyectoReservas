package org.adaschool.proyectoReservas.application.lasting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EMessage {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"Usuario no encontrado"),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND,"Rol no encontrado"),
    CLIENT_NOT_FOUND(HttpStatus.NOT_FOUND,"Cliente no encontrado"),
    BOOKING_NOT_FOUND(HttpStatus.NOT_FOUND,"Reserva no encontrada"),
    TABLE_NOT_FOUND(HttpStatus.NOT_FOUND,"Mesa no encontrada");

    private final HttpStatus status;
    private final String message;

}
