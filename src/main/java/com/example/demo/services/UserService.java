package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    public void saveUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, UserEntity.class));
    }
}
