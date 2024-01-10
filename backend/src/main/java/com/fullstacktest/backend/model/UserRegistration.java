package com.fullstacktest.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "UserRegistrations")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Sex sex;
    @NotNull
    private int age;
    @NotNull
    private String country;

}
