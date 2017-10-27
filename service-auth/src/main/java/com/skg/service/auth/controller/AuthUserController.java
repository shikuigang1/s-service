package com.skg.service.auth.controller;

import com.skg.service.auth.service.AuthUserService;
import com.skg.service.auth.util.JwtAuthenticationRequest;
import com.skg.service.auth.util.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("userjwt")
public class AuthUserController {
    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        final String token = authUserService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authUserService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ResponseEntity<?> verify(String token) throws Exception {
        authUserService.validate(token);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "invalid", method = RequestMethod.POST)
    public ResponseEntity<?> invalid(@RequestHeader("access-token") String token){
        authUserService.invalid(token);
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
