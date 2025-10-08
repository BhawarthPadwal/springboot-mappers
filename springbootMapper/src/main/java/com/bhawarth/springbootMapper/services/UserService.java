package com.bhawarth.springbootMapper.services;

import com.bhawarth.springbootMapper.dto.StudentDTO;
import com.bhawarth.springbootMapper.dto.User3DTO;
import com.bhawarth.springbootMapper.dto.UserDTO;
import com.bhawarth.springbootMapper.entities.Student;
import com.bhawarth.springbootMapper.entities.UserEntity;
import com.bhawarth.springbootMapper.mapper.ModelMapperClass;
import com.bhawarth.springbootMapper.mapper.UserMapper;
import com.bhawarth.springbootMapper.repository.StudentRepository;
import com.bhawarth.springbootMapper.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapperClass modelMapperClass;

    @Autowired
    private UserMapper userMapper;

    // Entity -> DTO
    public UserDTO getUserDTO(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        return modelMapperClass.modelMapper().map(userEntity, UserDTO.class);
    }

//    public User3DTO getUserDTO2(Long id) {
//        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
//        return modelMapperClass.modelMapper().typeMap(UserEntity.class, User3DTO.class)
//                .addMapping(UserEntity::getName, User3DTO:: setUsername)
//                .addMapping(UserEntity::getEmail, User3DTO::setUseremail);
//    }
public User3DTO getUserDTO2(Long id) {
    UserEntity userEntity = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found."));

    ModelMapper modelMapper = modelMapperClass.modelMapper();

    // Create or get TypeMap for custom mapping
    modelMapper.typeMap(UserEntity.class, User3DTO.class)
            .addMapping(UserEntity::getName, User3DTO::setUsername)
            .addMapping(UserEntity::getEmail, User3DTO::setUseremail);

    // Map the entity to DTO
    return modelMapper.map(userEntity, User3DTO.class);
}


    public UserEntity createSave(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper = Mappers.getMapper(UserMapper.class);
        StudentDTO studentDTO = userMapper.mapStudentToStudentDTO(student);

//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(student.getId());
//        studentDTO.setName(student.getUsername());
//        studentDTO.setDob(DateTimeFormatter.ISO_LOCAL_DATE.format(student.getDateOfBirth()));
//        studentDTO.setPassword(student.getPassword());
//        studentDTO.setStatus(student.getStatus());

        return studentDTO;
    }

//    // DTO -> Entity
//    public UserEntity saveUser(UserDTO userDTO) {
//
//    }
}
