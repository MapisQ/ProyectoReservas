package org.adaschool.proyectoReservas.domain.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "\"client\"")
public class Client {
    @Id
    @SequenceGenerator(name = "id_client", sequenceName = "id_cclient")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_client_generator")
    private Integer id;
    private String name;
    private String lastName;
    private String document;
    private String phoneNumber;

    @OneToMany
    @ToString.Exclude
    private List<Booking> booking;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName) && Objects.equals(document, client.document) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(booking, client.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, document, phoneNumber, booking);
    }
}
