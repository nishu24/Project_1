package com.ers.repositories;

import com.ers.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginRepos extends JpaRepository<Login, Integer> {
//    Optional<Login> findByEmail(String email);
//    Optional<Login> findByUsernameOrEmail(String username, String email);
//    Optional<Login> findByUsername(String username);
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);
}
