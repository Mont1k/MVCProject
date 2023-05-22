package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen", sequenceName = "agency_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @Column(length = 10000000)
    private String img;

    @ManyToMany(mappedBy = "agencies",cascade = ALL)
    private List<Customer> customers;

    @OneToMany(mappedBy = "agencies",cascade = ALL)
    private List<House> house;

    public Agency(String name, String country, String phoneNumber, String email,String img) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.img= img;
    }

}
