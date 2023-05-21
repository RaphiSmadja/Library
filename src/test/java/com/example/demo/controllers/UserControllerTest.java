package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    public void getAllUsers() {
        // GIVEN
        Mockito.when(userService.getAllUsers()).thenReturn(new ArrayList<UserDTO>());

        // WHEN
        userController.getAllUsers();

        // THEN
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
    }
}
