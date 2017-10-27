package com.skg.service.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Value("${admin.id}")
    private String adminId;
    @Value("${admin.secret}")
    private String adminSecret;
    @Value("${admin.token-header}")
    private String adminTokenHeader;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminSecret() {
        return adminSecret;
    }

    public void setAdminSecret(String adminSecret) {
        this.adminSecret = adminSecret;
    }

    public String getAdminTokenHeader() {
        return adminTokenHeader;
    }

    public void setAdminTokenHeader(String adminTokenHeader) {
        this.adminTokenHeader = adminTokenHeader;
    }

}
