package com.project.uber.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "login_user", schema = "electric")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    // Note: You have many other columns, but we only need these for login.
    // You can add the rest (phone, is_employee, etc.) if needed.
}