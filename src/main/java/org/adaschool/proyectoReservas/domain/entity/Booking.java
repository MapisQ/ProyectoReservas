package org.adaschool.proyectoReservas.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.adaschool.proyectoReservas.application.enums.EState;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "booking")
public class Booking {

    @Id
    @SequenceGenerator(name = "id_booking", sequenceName = "id_booking")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_booking_generator")
    private Integer id;
    private Date dateBooking;
    private String description;
    private EState state;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToMany
    @ToString.Exclude
    private List<Table> table;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(dateBooking, booking.dateBooking) && Objects.equals(description, booking.description) && state == booking.state && Objects.equals(user, booking.user) && Objects.equals(client, booking.client) && Objects.equals(table, booking.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateBooking, description, state, user, client, table);
    }
}
