package com.example.usermanagementsystem.repository;

import com.example.usermanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDTORepository extends JpaRepository<User, Integer> {
}
