package com.openschool.homework4.service;


import com.openschool.homework4.entity.AuthUser;
import com.openschool.homework4.repository.AuthUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthUserService {
    private final AuthUserRepository repository;

    public AuthUserService(AuthUserRepository repository){
        this.repository = repository;
    }

    @PostConstruct
    public void addAdmin() {
        if (!repository.existsByName("admin")) {
            AuthUser admin = new AuthUser();
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setRoles("ADMIN");
            repository.save(admin);
        }
    }

    public void addUser(AuthUser user){
        user.setPassword(user.getPassword());
        repository.save(user);
    }

    public void addRole(Long id, String role){
        Optional<AuthUser> user = repository.findById(id);
        user.ifPresent(authUser -> {
            authUser.setRoles(role);
            repository.save(authUser);
        });
    }

    public Optional<AuthUser> findUser(Long id){
        return repository.findById(id);
    }

}
