package com.junior.autenticacao03.repository;

import com.junior.autenticacao03.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserReposirory extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
