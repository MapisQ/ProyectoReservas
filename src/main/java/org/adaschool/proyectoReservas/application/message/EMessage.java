package org.adaschool.proyectoReservas.application.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EMessage {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"Usuario no encontrado"),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND,"Rol no encontrado");

    private final HttpStatus status;
    private final String message;

}
