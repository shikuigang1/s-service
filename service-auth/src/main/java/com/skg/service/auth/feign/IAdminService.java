package com.skg.service.auth.feign;

import com.skg.service.auth.config.FeignAdminConfiguration;
import com.skg.service.core.model.Admin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "admin-service",configuration = FeignAdminConfiguration.class)
public interface IAdminService {

    @RequestMapping(value = "/admin/get", method = RequestMethod.POST)
    public String getAdminByUsername(@RequestParam("username") String username, @RequestParam("password") String password);

}
