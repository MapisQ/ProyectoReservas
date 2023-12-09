package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.lasting.EMessage;
import org.adaschool.proyectoReservas.domain.entity.Booking;
import org.adaschool.proyectoReservas.domain.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public record BookingService(BookingRepository bookingRepository) {

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingById(Integer idBooking) {
        return bookingRepository.findById(idBooking);
    }

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    public void updateBooking(Integer idBooking) throws ReservationException {
        Optional<Booking> bookingOptional = bookingRepository.findById(idBooking);
        if (bookingOptional.isPresent()) {
            Booking bookingValue = bookingOptional.get();
            bookingValue.setBookingDate(bookingValue.getBookingDate());
            bookingValue.setDescription(bookingValue.getDescription());
            bookingValue.setBookingHour(bookingValue.getBookingHour());
            bookingValue.setStateReservation(bookingValue.getStateReservation());
        }
        throw new ReservationException(EMessage.BOOKING_NOT_FOUND);
    }
}
