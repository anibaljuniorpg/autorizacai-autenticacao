package com.junior.autenticacao03.service;

import com.junior.autenticacao03.configuration.SecurityConfiguration;
import com.junior.autenticacao03.domain.User;
import com.junior.autenticacao03.dtos.LoginRequestDTO;
import com.junior.autenticacao03.dtos.LoginResponseDTO;
import com.junior.autenticacao03.exception.AuthenticationException;
import com.junior.autenticacao03.exception.RegistrationException;
import com.junior.autenticacao03.repository.UserReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserReposirory reposirory;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SecurityConfiguration securityConfiguration;

    //Metodo de login
    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        User login = (User) reposirory.findByLogin(requestDTO.login());
        if (login == null || !securityConfiguration.passwordEncoder().matches(requestDTO.password(), login.getPassword())){
            throw new AuthenticationException();
        }
        String token = tokenService.generateToken(login);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(requestDTO.login(), token);
        return loginResponseDTO;
    }

    //Metodo de registro
    public  LoginResponseDTO register(LoginRequestDTO requestDTO){
        User user = (User) reposirory.findByLogin(requestDTO.login());
        if (user != null){
            throw  new RegistrationException();
        }
        /*User newUser = User.builder()
                .login(requestDTO.login())
                .password(securityConfiguration.passwordEncoder().encode(requestDTO.password()))
                .role(requestDTO.role()).build();*/
        User newUser = new User(requestDTO.login(), securityConfiguration.passwordEncoder().encode(requestDTO.password()), requestDTO.role());
        String token = tokenService.generateToken(newUser);
        reposirory.save(newUser);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(requestDTO.login(), token);
        return loginResponseDTO;
    }
}
