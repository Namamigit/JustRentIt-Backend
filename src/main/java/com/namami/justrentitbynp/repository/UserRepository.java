package com.namami.justrentitbynp.repository;

import com.namami.justrentitbynp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}

