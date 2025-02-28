package com.junior.autenticacao03.dtos;

import com.junior.autenticacao03.domain.UserRole;

public record LoginRequestDTO(String login, String password, UserRole role) {
}
