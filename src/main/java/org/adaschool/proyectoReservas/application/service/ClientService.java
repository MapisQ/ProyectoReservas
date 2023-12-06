package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.message.EMessage;
import org.adaschool.proyectoReservas.domain.entity.Client;
import org.adaschool.proyectoReservas.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public record ClientService(ClientRepository clientRepository) {

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> findClientById(Integer idClient) {
        return clientRepository.findById(idClient);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public void updateClient(Integer idClient) throws ReservationException {
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        if (clientOptional.isPresent()) {
            Client clientValue = clientOptional.get();
            clientValue.setName(clientValue.getName());
            clientValue.setLastName(clientValue.getLastName());
            clientValue.setPhoneNumber(clientValue.getPhoneNumber());
        }
        throw new ReservationException(EMessage.CLIENT_NOT_FOUND);
    }

}
