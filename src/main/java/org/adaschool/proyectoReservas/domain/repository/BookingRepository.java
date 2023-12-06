package org.adaschool.proyectoReservas.domain.repository;

import org.adaschool.proyectoReservas.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
