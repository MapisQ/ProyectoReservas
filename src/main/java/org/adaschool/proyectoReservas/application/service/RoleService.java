package org.adaschool.proyectoReservas.application.service;

import org.adaschool.proyectoReservas.application.exception.ReservationException;
import org.adaschool.proyectoReservas.application.message.EMessage;
import org.adaschool.proyectoReservas.domain.entity.Role;
import org.adaschool.proyectoReservas.domain.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record RoleService(RoleRepository roleRepository) {

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public Optional<Role> findRoleById(Integer idRole) {
        return roleRepository.findById(idRole);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    public void substractRoleById(Integer idRole) throws ReservationException {
        Role role = roleRepository.findById(idRole)
                .orElseThrow(() -> new ReservationException(EMessage.ROLE_NOT_FOUND));
        roleRepository.delete(role);
    }

    public void updateRole(Integer idRole) throws ReservationException {

        Optional<Role> optionalRole = findRoleById(idRole);
        if (optionalRole.isPresent()) {
            Role roleValue = optionalRole.get();
            roleValue.setName(roleValue.getName());
        }
        throw new ReservationException(EMessage.ROLE_NOT_FOUND);
    }
}
