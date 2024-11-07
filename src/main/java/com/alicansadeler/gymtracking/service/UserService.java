package com.alicansadeler.gymtracking.service;

import com.alicansadeler.gymtracking.dto.UserDTO;
import com.alicansadeler.gymtracking.entity.Users;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Users saveUser(UserDTO userDTO);
    Users updateUser(Long id, UserDTO userDTO);
    Optional<Users> getUserById(Long id);
    List<Users> getAllUsers();
    void deleteUser(Long id);
}


