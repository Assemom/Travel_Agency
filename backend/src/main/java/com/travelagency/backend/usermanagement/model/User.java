package com.travelagency.backend.usermanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "users")
@Setter
@Getter
@EnableJpaAuditing
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email format")
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, length = 11)
    private String phoneNumber;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private LocalDate birthDate;
    private int age;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String government;

    private double budget;
    private String image;
    private String preferences;
    private String role = "USER";

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    //@OneToMany
    //private List<Booking> bookings;
    public User() {
    }
    public User(String firstName, String lastName, String email, String password,
                String phoneNumber, String nationality, LocalDate birthDate, int age,
                String country, String government, double budget, String image, String preferences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.age = calculateAge();
        this.country = country;
        this.government = government;
        this.budget = budget;
        this.image = image;
        this.preferences = preferences;
    }
    private int calculateAge() {
        // Assuming birthDate is in the format "yyyy-MM-dd"
        LocalDate birth = birthDate;
        LocalDate now = LocalDate.now();
        return Period.between(birth, now).getYears();
    }
}
