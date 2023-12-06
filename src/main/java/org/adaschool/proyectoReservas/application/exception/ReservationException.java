package org.adaschool.proyectoReservas.application.exception;

import org.adaschool.proyectoReservas.application.message.EMessage;
import org.springframework.http.HttpStatus;

public class ReservationException extends Exception {

    private HttpStatus status;
    private String message;

    public ReservationException(EMessage message) {
        this.status = message.getStatus();
        this.message = message.getMessage();
    }
}
