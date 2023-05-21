package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void getAllUsers() {
        // GIVEN
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("firstname");
        userEntity.setLastName("lastname");
        userEntity.setBookEntities(new ArrayList<>());

        // WHEN
        when(userRepository.findAll()).thenReturn(List.of(userEntity));
        UserDTO expected = new ModelMapper().map(userEntity, UserDTO.class);
        when(modelMapper.map(userEntity, UserDTO.class)).thenReturn(expected);
        List<UserDTO> actual = userService.getAllUsers();

        // THEN
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals(expected.getIdUser(), 1L);
        Assertions.assertEquals(expected.getFirstname(), actual.get(0).getFirstname());
        Assertions.assertEquals(expected.getLastname(), actual.get(0).getLastname());
        Assertions.assertEquals(expected.getBookDTOList(), actual.get(0).getBookDTOList());
    }
}
