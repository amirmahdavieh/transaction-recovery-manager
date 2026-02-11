package com.amirmahdavieh.trm.domain;

import java.time.LocalDate;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;

    public User(Long id, String firstName, String lastName, LocalDate birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthdate() { return birthdate; }
}
