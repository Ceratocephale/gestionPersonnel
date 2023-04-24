package models.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "person")
@Getter @Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "niss", nullable = false, unique = true)
    private String niss;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "sex", nullable = false)
    private Sex sex;
    @Column(name = "tilte", nullable = false)
    private String title;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "active")
    private boolean active;

    public enum Status {
        MAGASINIER,
        ADMINISTRATIF
    }

    public enum Sex {
        MALE,
        FEMALE,
        OTHER
    }

}
