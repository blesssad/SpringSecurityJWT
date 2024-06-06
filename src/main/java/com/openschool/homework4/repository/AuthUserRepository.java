package com.openschool.homework4.repository;

import com.openschool.homework4.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByName(String name);
    Optional<AuthUser> findById(Long id);
    boolean existsByName(String name);
}
