package com.bhawarth.springbootMapper.mapper;

import com.bhawarth.springbootMapper.dto.StudentDTO;
import com.bhawarth.springbootMapper.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "name")
    @Mapping(source = "dateOfBirth", target = "dob", dateFormat = "yyyy-MM-dd")
    StudentDTO mapStudentToStudentDTO(Student student);
}
