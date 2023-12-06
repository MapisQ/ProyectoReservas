package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.ClientService;
import org.adaschool.proyectoReservas.domain.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
public record ClientController(ClientService clientService) {

    @PostMapping("/save/client")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        clientService.createClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/client")
    public ResponseEntity<?> allClients() {
        clientService.listAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search/{idClient}")
    public ResponseEntity<?> findClientById(@PathVariable("idClient") Integer idClient) {
        clientService.findClientById(idClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{idClient}")
    public ResponseEntity<?> updateClient(@PathVariable("idClient") Integer idClient) throws ReservationException {
        clientService.updateClient(idClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
