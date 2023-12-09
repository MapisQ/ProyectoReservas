package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.lasting.EMessage;
import org.adaschool.proyectoReservas.domain.entity.User;
import org.adaschool.proyectoReservas.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record UserService(UserRepository userRepository) {

    //Llamar interface del repository y llamar la instruccion de Save
    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(Integer idUser) {
        return userRepository.findById(idUser);
    }

    public void deleteUser(Integer idUser) throws ReservationException {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ReservationException(EMessage.USER_NOT_FOUND));
        userRepository.delete(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void updateUser(Integer idUser) throws ReservationException {
        Optional<User> optionalUser = findUserById(idUser);
        if (optionalUser.isPresent()) {
            User userValue = optionalUser.get();
            userValue.setName(userValue.getName());
            userValue.setLastName(userValue.getLastName());
            userValue.setRoles(userValue.getRoles());

            createUser(userValue);
        }
        throw new ReservationException(EMessage.USER_NOT_FOUND);
    }

}
