package com.skg.service.auth.service.impl;

import com.skg.service.auth.feign.IAdminService;
import com.skg.service.auth.service.AdminService;
import com.skg.service.auth.service.UserService;
import com.skg.service.auth.util.JwtTokenUtil;
import com.skg.service.core.model.Admin;
import com.skg.service.core.util.JWTInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private JwtTokenUtil jwtTokenUtil;
    private IAdminService iAdminService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String login(String username, String password) throws Exception {
        //iAdminService.getAdminByUsername(username,password);
        Admin info = null;
        String token = "";
        if (encoder.matches(password, info.getPassword())) {
            token = jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getMobile()));
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
