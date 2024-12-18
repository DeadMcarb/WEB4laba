package org.example.web4laba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restorer")
@NamedQueries({
        @NamedQuery(name = "Restorer.findAll", query = "select c from Restorer c")
})
public class Restorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restorer_id", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Lob
    @Column(name = "second_name", nullable = false)
    private String secondName;

    @NotNull
    @Lob
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Lob
    @Column(name = "email", nullable = false)
    private String email;

}