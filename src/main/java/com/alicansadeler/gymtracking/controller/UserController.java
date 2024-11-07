package com.alicansadeler.gymtracking.controller;

import com.alicansadeler.gymtracking.dto.UserDTO;
import com.alicansadeler.gymtracking.dto.FitnessApiResponse;
import com.alicansadeler.gymtracking.entity.Users;
import com.alicansadeler.gymtracking.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public FitnessApiResponse<Users> createUser(@Valid @RequestBody UserDTO userDTO) {
        Users user = userService.saveUser(userDTO);
        return new FitnessApiResponse<>(true, "User created successfully", user);
    }

    @PutMapping("/{id}")
    public FitnessApiResponse<Users> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        Users user = userService.updateUser(id, userDTO);
        return new FitnessApiResponse<>(true, "User updated successfully", user);
    }

    @GetMapping("/{id}")
    public FitnessApiResponse<Optional<Users>> getUser(@PathVariable Long id) {
        Optional<Users> user = userService.getUserById(id);
        return new FitnessApiResponse<>(true, "User retrieved successfully", user);
    }

    @GetMapping
    public FitnessApiResponse<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return new FitnessApiResponse<>(true, "All users retrieved", users);
    }

    @DeleteMapping("/{id}")
    public FitnessApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new FitnessApiResponse<>(true, "User deleted successfully", null);
    }
}
