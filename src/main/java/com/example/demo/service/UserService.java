package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;

import java.util.List;

public interface UserService {

        UserResponseDto saveUser(UserRequestDto requestDto);

        List<UserResponseDto> fetchUsers();

        UserResponseDto fetchUser(Long id);

        UserResponseDto updateUser(Long id, UserRequestDto requestDto);

        void deleteUser(Long id);

        void deleteAllUsers();

}