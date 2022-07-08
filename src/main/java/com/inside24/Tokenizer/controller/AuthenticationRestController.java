package com.inside24.Tokenizer.controller;

import com.inside24.Tokenizer.dto.AuthenticationRequestDto;
import com.inside24.Tokenizer.model.User;
import com.inside24.Tokenizer.security.jwt.JwtTokenProvider;
import com.inside24.Tokenizer.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
@Slf4j
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login (@RequestBody AuthenticationRequestDto requestDto) {
        log.info("interred in login");
        try {
            String username = requestDto.getName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByName(username);

            if (user == null) {
                log.info("user not found", username);
                throw new UsernameNotFoundException("User with username username: " + username + " not found");

            }
            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("token", token);
            log.info("token returned", token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
