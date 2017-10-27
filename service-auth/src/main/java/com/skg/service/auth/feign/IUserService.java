package com.skg.service.auth.feign;

import com.skg.service.core.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface IUserService {
    @RequestMapping(value = "/api/user/username/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@RequestParam("username") String username);

}
