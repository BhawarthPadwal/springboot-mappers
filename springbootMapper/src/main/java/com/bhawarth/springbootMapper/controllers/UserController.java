package com.bhawarth.springbootMapper.controllers;

import com.bhawarth.springbootMapper.dto.StudentDTO;
import com.bhawarth.springbootMapper.dto.User3DTO;
import com.bhawarth.springbootMapper.dto.UserDTO;
import com.bhawarth.springbootMapper.entities.Student;
import com.bhawarth.springbootMapper.entities.UserEntity;
import com.bhawarth.springbootMapper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User3DTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDTO2(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.createSave(userEntity));
    }

    @GetMapping("/students")
    public ResponseEntity<StudentDTO> getByUserId(@RequestParam Long id) {
        return ResponseEntity.ok(userService.getStudentById(id));
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student> createUser(@RequestBody Student student) {
        return ResponseEntity.ok(userService.createStudent(student));
    }
}
