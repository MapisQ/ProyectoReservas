package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.UserService;
import org.adaschool.proyectoReservas.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
public record UserController(UserService userService) {
   @PostMapping("/save/user")
   public ResponseEntity<?> saveUser(@RequestBody User user) {
      userService.createUser(user);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @GetMapping("/all/user")
   public ResponseEntity<?> allUsers() {
      userService.listAll();
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("search/{idUser}")
   public ResponseEntity<?> findUserById(@PathVariable("idUser") Integer idUser) {
      userService.findUserById(idUser);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @DeleteMapping("delete/{idUser}")
   public ResponseEntity<?> substractUser(@PathVariable("idUser") Integer idUser) throws ReservationException, ReservationException {
      userService.deleteUser(idUser);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

   @PutMapping("update/{idUser}")
   public ResponseEntity<?> updateUser(@PathVariable("idUser") Integer idUser) throws ReservationException {
      userService.updateUser(idUser);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
