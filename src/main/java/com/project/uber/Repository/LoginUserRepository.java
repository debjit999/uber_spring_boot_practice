package com.project.uber.Repository;

import com.project.uber.Entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

    // Spring automatically generates: SELECT * FROM login_user WHERE email = ? AND is_active = 1 AND is_deleted = 0
    Optional<LoginUser> findByEmailAndIsActiveTrueAndIsDeletedFalse(String email);
}