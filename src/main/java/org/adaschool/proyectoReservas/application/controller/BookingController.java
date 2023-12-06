package org.adaschool.proyectoReservas.application.controller;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.service.BookingService;
import org.adaschool.proyectoReservas.domain.entity.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/booking")
public record BookingController(BookingService bookingService) {

    @PostMapping("/save/booking")
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/booking")
    public ResponseEntity<?> allBooking() {
        bookingService.listAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search/{idBooking}")
    public ResponseEntity<?> findBookingById(@PathVariable("idBooking") Integer idBooking) {
        bookingService.findBookingById(idBooking);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("update/{idBooking}")
    public ResponseEntity<?> updateBooking(@PathVariable("idBooking") Integer idBooking) throws ReservationException {
        bookingService.updateBooking(idBooking);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
