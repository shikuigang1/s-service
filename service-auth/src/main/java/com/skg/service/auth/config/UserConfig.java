package com.skg.service.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ace on 2017/9/12.
 */
@Configuration
public class UserConfig {
    @Value("${user.id}")
    private String userId;
    @Value("${user.secret}")
    private String userSecret;
    @Value("${user.token-header}")
    private String userTokenHeader;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    public String getUserTokenHeader() {
        return userTokenHeader;
    }

    public void setUserTokenHeader(String userTokenHeader) {
        this.userTokenHeader = userTokenHeader;
    }
}
