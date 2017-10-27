package com.skg.service.auth.service.impl;

import com.skg.service.auth.feign.IUserService;
import com.skg.service.auth.service.AuthUserService;
import com.skg.service.auth.util.JwtTokenUtil;
import com.skg.service.core.model.User;
import com.skg.service.core.util.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthUserServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(String username, String password) throws Exception {
        User info = userService.getUserByUsername(username);
        String token = "";
        if (encoder.matches(password, info.getPassword())) {
            token = jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }

    @Override
    public void validate(String token) throws Exception {

    }

    @Override
    public Boolean invalid(String token) {
        return null;
    }
}
