package com.skg.service.auth.service;

public interface AuthAdminService {

    String login(String username, String password) throws Exception;
    String refresh(String oldToken);
    void validate(String token) throws Exception;
    //FrontUser getUserInfo(String token) throws Exception;
    Boolean invalid(String token);

}
