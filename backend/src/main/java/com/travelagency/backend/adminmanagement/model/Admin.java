package com.travelagency.backend.adminmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JavaType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
@Setter
@Getter
@EnableJpaAuditing
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Column(nullable = false)
    private String name;
    @Getter
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email format")
    private String email;
    @Getter
    @Column(nullable = false)
    private String password;
    private String role = "ADMIN";

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Admin() {
    }
    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
