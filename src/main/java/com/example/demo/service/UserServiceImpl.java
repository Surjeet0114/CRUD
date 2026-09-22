package com.example.demo.service;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto requestDto) {

        User user = new User();

        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setDepartment(requestDto.getDepartment());
        user.setDesignation(requestDto.getDesignation());
        user.setSalary(requestDto.getSalary());
        user.setJoiningDate(requestDto.getJoiningDate());
        user.setStatus(requestDto.getStatus());

        User savedUser = userRepository.save(user);

        return mapToResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> fetchUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto fetchUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        return mapToResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id,
                                      UserRequestDto requestDto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setDepartment(requestDto.getDepartment());
        user.setDesignation(requestDto.getDesignation());
        user.setSalary(requestDto.getSalary());
        user.setJoiningDate(requestDto.getJoiningDate());
        user.setStatus(requestDto.getStatus());

        User updatedUser = userRepository.save(user);

        return mapToResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        userRepository.delete(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    private UserResponseDto mapToResponseDto(User user) {

        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getDepartment(),
                user.getDesignation(),
                user.getSalary(),
                user.getJoiningDate(),
                user.getStatus(),
                user.getCreatedAt(),
                user.getUpdatedAt()
                );
    }
}