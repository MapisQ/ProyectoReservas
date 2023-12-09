package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.domain.dto.AuthenticationDto;
import org.adaschool.proyectoReservas.domain.dto.UserDto;
import org.adaschool.proyectoReservas.domain.entity.User;
import org.adaschool.proyectoReservas.domain.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(
        UserRepository userRepository,
        JwtService jwtService,
        PasswordEncoder passwordEncoder,
        AuthenticationManager authenticationManager
) {
    public String register(UserDto userDto) {
        //Falta el tema del mapper para quitar lo de .no se que .otro . así
        return  null;
    }
    public String authenticate(AuthenticationDto authenticationDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.email(),authenticationDto.password())
        );
        User user = userRepository.findUserByEmail(authenticationDto.email()).orElseThrow();
        return jwtService.generateToken(user);

    }
}
