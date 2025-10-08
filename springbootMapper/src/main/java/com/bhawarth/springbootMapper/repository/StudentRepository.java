package com.bhawarth.springbootMapper.repository;

import com.bhawarth.springbootMapper.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
