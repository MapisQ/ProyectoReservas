package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.TableService;
import org.adaschool.proyectoReservas.domain.entity.Table;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/table")
public record TableController(TableService tableService) {

    @PostMapping("/save/table")
    public ResponseEntity<?> saveTable(@RequestBody Table tables) {
        tableService.createTable(tables);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/table")
    public ResponseEntity<?> allTables() {
        tableService.listAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search/{idTable}")
    public ResponseEntity<?> findTableById(@PathVariable("idTable") Integer idTable) {
        tableService.findTableById(idTable);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("update/{idTable}")
    public ResponseEntity<?> updateTable(@PathVariable("idTable") Integer idTable) throws ReservationException {
        tableService.updateTable(idTable);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
