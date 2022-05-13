package com.ers.repositories;

import com.ers.models.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsesRolesRepos extends JpaRepository<UserRoles,Integer> {
}
