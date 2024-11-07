package com.alicansadeler.gymtracking.service;

import com.alicansadeler.gymtracking.dto.UserDTO;
import com.alicansadeler.gymtracking.entity.Users;
import com.alicansadeler.gymtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(@Valid UserDTO userDTO) {
        Users user = new Users();
        user.setName(userDTO.name());
        user.setSurName(userDTO.surName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Long id, @Valid UserDTO userDTO) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userDTO.name());
        existingUser.setSurName(userDTO.surName());
        existingUser.setEmail(userDTO.email());
        existingUser.setPassword(userDTO.password());
        return userRepository.save(existingUser);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
