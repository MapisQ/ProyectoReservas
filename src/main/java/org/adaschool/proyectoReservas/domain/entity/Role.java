package org.adaschool.proyectoReservas.domain.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.adaschool.proyectoReservas.application.enums.ERoles;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "\"role\"")
public class Role {

    @Id
    @SequenceGenerator(name = "id_role_sequence", sequenceName = "id_role_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_role_generator")
    private Integer id;
    private ERoles roles;
    private Integer idRole_user;

    @OneToMany
    @ToString.Exclude
    private List<User> usersList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && roles == role.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roles);
    }
}
