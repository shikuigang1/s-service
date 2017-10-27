package com.skg.service.auth.controller;

import com.skg.service.auth.constant.AuthConstant;
import com.skg.service.auth.service.AuthAdminService;
import com.skg.service.auth.service.AuthUserService;
import com.skg.service.auth.util.JwtAuthenticationRequest;
import com.skg.service.auth.util.JwtAuthenticationResponse;
import com.skg.service.core.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("adminjwt")
public class AuthAdminController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthAdminService authAdminService;

    @RequestMapping(value = "token", method = RequestMethod.GET)
    public ResponseEntity<?> createAuthenticationToken(String username,String password
            ) throws Exception {
        final String token = authAdminService.login(username, password);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse(token);
        response.setStatus(AuthConstant.JWT_TOKEN_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authAdminService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ResponseEntity<?> verify(String token) throws Exception {
        authAdminService.validate(token);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "invalid", method = RequestMethod.GET)
    public ResponseEntity<?> invalid(@RequestHeader("access-token") String token){
        authAdminService.invalid(token);
        return ResponseEntity.ok(true);
    }

   /* @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(String token) throws Exception {
        FrontUser userInfo = authUserService.getUserInfo(token);
        if(userInfo==null) {
            return ResponseEntity.status(401).body(false);
        } else {
            return ResponseEntity.ok(userInfo);
        }
    }*/
}
