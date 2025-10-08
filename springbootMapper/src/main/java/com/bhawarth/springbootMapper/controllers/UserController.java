package com.bhawarth.springbootMapper.controllers;

import com.bhawarth.springbootMapper.dto.UserDTO;
import com.bhawarth.springbootMapper.entities.UserEntity;
import com.bhawarth.springbootMapper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDTO(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.createSave(userEntity));
    }

}
