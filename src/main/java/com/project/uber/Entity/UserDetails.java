package com.project.uber.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_details", schema = "electric")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Integer userId;

    @Column(name = "is_electrician", nullable = false)
    private Boolean isElectrician = false;

    @Column(name = "is_customer", nullable = false)
    private Boolean isCustomer = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Optional: unidirectional / bidirectional relation to LoginUser
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "userId_fk_details_login_user"))
    private LoginUser loginUser;
}