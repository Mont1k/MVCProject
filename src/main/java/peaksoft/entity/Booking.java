package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
    public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
        @SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq", allocationSize = 1)
        private Long id;

        @Transient
        private Long customer_id;
        @Transient
        private Long house_id;

        @OneToOne(cascade = { DETACH, MERGE, REFRESH})
        private House houses;

        @ManyToOne(cascade = { DETACH, MERGE, REFRESH,REMOVE})
        private Customer customers;

    }

