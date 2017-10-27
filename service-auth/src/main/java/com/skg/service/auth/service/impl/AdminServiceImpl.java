package com.skg.service.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.skg.service.auth.feign.IAdminService;
import com.skg.service.auth.service.AdminService;
import com.skg.service.auth.util.JwtTokenUtil;
import com.skg.service.core.model.Admin;
import com.skg.service.core.util.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IAdminService iAdminService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String login(String username, String password) throws Exception {
        //iAdminService.getAdminByUsername(username,password)
        String json  = iAdminService.getAdminByUsername(username,password);
        Admin info  = JSONObject.parseObject(json, new TypeReference<Admin>() {});
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
