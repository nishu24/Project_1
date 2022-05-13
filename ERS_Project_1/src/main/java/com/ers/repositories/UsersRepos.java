package com.ers.repositories;

import com.ers.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepos extends JpaRepository<Users, Integer> {

}
