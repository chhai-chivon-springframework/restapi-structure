package com.gazatem.java.rest.repository;

import com.gazatem.java.rest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);
}
