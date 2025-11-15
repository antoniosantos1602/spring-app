package com.app.spring_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.spring_app.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
