package com.project.uber.Repository;

import com.project.uber.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {


    boolean existsByUserId(Integer userId);
}
