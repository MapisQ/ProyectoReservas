package org.adaschool.proyectoReservas.domain.dto;

import org.adaschool.proyectoReservas.application.lasting.ERoles;

public record UserDto(
        Integer id,
        String name,
        String lastName,
        String email,
        String password,
        boolean enable,
        ERoles roles,
        Integer document
) {
}
