package org.adaschool.proyectoReservas.domain.repository;

import org.adaschool.proyectoReservas.domain.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table,Integer> {
}
