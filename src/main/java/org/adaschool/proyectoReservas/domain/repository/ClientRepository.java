package org.adaschool.proyectoReservas.domain.repository;

import org.adaschool.proyectoReservas.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
