package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.lasting.EMessage;
import org.adaschool.proyectoReservas.domain.entity.Table;
import org.adaschool.proyectoReservas.domain.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public record TableService(TableRepository tablesRepository) {

    public void createTable(Table tables) {
        tablesRepository.save(tables);
    }

    public Optional<Table> findTableById(Integer idTable) {
        return tablesRepository.findById(idTable);
    }

    public List<Table> listAll() {
        return tablesRepository.findAll();
    }

    public void updateTable(Integer idTable) throws ReservationException {
        Optional<Table> tableOptional = tablesRepository.findById(idTable);
        if (tableOptional.isPresent()) {
            Table tableValue = tableOptional.get();
            tableValue.setChairsNumber(tableValue.getChairsNumber());
        }
        throw new ReservationException(EMessage.TABLE_NOT_FOUND);
    }
}
