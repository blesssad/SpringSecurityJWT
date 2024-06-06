package com.openschool.homework4.controller;

import com.openschool.homework4.entity.AuthUser;
import com.openschool.homework4.security.CustomAuthUserDetails;
import com.openschool.homework4.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthUserService authUserService;
    @GetMapping( "/getCurrentUser")
    public ResponseEntity<Optional<AuthUser>> getCurrentUser(@AuthenticationPrincipal CustomAuthUserDetails userDetails) {
        Optional<AuthUser> authUser = authUserService.findUser(userDetails.getId());
        return ResponseEntity.ok(authUser);
    }


    @PostMapping("/addRole/{id}")
    public ResponseEntity<?> addRole(@PathVariable Long id, @RequestParam String role) {
        authUserService.addRole(id, role);
        return ResponseEntity.ok("Role changed!");
    }
}
