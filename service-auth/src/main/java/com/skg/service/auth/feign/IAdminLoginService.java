package com.skg.service.auth.feign;

import com.skg.service.core.model.Admin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "admin-service",configuration = {})
public interface IAdminLoginService {
    @RequestMapping(value = "/api/admin/username/{username}", method = RequestMethod.GET)
    public Admin getAdminByUsername(@RequestParam("username") String username);
}
