package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.UserService;
import org.adaschool.proyectoReservas.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
public record UserController(UserService userService) {
   @PostMapping("/save/users")
   public ResponseEntity<?> saveUser(@RequestBody User user) {
      userService.createUser(user);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/all")
   public ResponseEntity<?> allUsers() {
      userService.listAll();
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("search/{id}")
   public ResponseEntity<?> findUserById(@PathVariable("idUser") Integer idUser) {
      userService.findUserById(idUser);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @DeleteMapping("delete/{id}")
   public ResponseEntity<?> substractUser(@PathVariable("idUser") Integer idUser) throws ReservationException, ReservationException {
      userService.deleteUser(idUser);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

   @PutMapping("update/{id}")
   public ResponseEntity<?> updateUser(@PathVariable("idUser") Integer idUser) throws ReservationException {
      userService.updateUser(idUser);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
