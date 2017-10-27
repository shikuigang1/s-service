package com.skg.service.auth.config;

import com.skg.service.auth.interceptor.AdminTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign 调用其他 服务 进行拦截
 */
@Configuration
public class FeignAdminConfiguration {
    @Bean
    AdminTokenInterceptor getAdminTokenInterceptor(){
        return new AdminTokenInterceptor();
    }
}
