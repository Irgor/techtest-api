package com.example.techtestapi.phone;

import com.example.techtestapi.user.User;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Phone {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String phone;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

}
