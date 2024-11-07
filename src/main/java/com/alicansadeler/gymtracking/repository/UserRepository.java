package com.alicansadeler.gymtracking.repository;

import com.alicansadeler.gymtracking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
