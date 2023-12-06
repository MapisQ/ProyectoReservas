package org.adaschool.proyectoReservas.domain.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "\"user\"")
public class User {
    @Id
    @SequenceGenerator(name = "id_user",sequenceName = "id_user")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_user_generator")
    private Integer id;
    private String name;
    private String lastName;
    private Integer document;

    @ManyToOne
    @JoinColumn(name = "idRole_user")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(document, user.document) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, document, role);
    }
}
