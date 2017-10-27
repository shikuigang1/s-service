package com.skg.service.auth.interceptor;

import com.skg.service.auth.config.AdminConfig;
import com.skg.service.auth.config.UserConfig;
import com.skg.service.auth.service.AdminService;
import com.skg.service.auth.service.AuthAdminService;
import com.skg.service.auth.service.AuthUserService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTokenInterceptor implements RequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(AdminTokenInterceptor.class);
    @Autowired
    private AdminConfig adminConfig;
    /*@Autowired
    private AdminService adminService;*/

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            //requestTemplate.header(adminConfig.getAdminTokenHeader(), adminService.login(adminConfig.getAdminId(), adminConfig.getAdminSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
