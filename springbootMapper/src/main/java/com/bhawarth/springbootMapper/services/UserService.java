package com.bhawarth.springbootMapper.services;

import com.bhawarth.springbootMapper.dto.UserDTO;
import com.bhawarth.springbootMapper.entities.UserEntity;
import com.bhawarth.springbootMapper.mapper.ModelMapperClass;
import com.bhawarth.springbootMapper.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapperClass modelMapperClass;

    // Entity -> DTO
    public UserDTO getUserDTO(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        return modelMapperClass.modelMapper().map(userEntity, UserDTO.class);
    }

    public UserEntity createSave(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

//    // DTO -> Entity
//    public UserEntity saveUser(UserDTO userDTO) {
//
//    }
}
