package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.RoleService;
import org.adaschool.proyectoReservas.domain.entity.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
public record RoleController(RoleService roleService) {

    @PostMapping("/save/roles")
    public ResponseEntity<?> saveRole(Role role) {
        roleService.createRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/roles")
    public ResponseEntity<?> findAll() {
        roleService.listRoles();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{idRole}")
    public ResponseEntity<?> findRoleById(@PathVariable("idRole") Integer idRole) {
        roleService.findRoleById(idRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{idRole}")
    public ResponseEntity<?> substractRole(@PathVariable("idRole") Integer idRole) throws ReservationException {
        roleService.substractRoleById(idRole);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Integer idRole) throws ReservationException {
        roleService.updateRole(idRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
