package com.skg.service.auth.interceptor;

import com.skg.service.auth.config.UserConfig;
import com.skg.service.auth.service.AuthUserService;
import com.skg.service.auth.service.UserService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTokenInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(UserTokenInterceptor.class);
    @Autowired
    private UserConfig userConfig;
    @Autowired
    private UserService userServicee;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header(userConfig.getUserTokenHeader(), userServicee.login(userConfig.getUserId(), userConfig.getUserSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
