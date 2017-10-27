package com.skg.service.gate.feignservice;

import com.skg.service.gate.interceptor.ServiceFeignInterceptor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *  通过 feign admin-api 中 提供的接口
 */
@FeignClient(value = "admin-service",configuration = {ServiceFeignInterceptor.class})
@RequestMapping("api")
public interface IUserService {


 /* @RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
  public UserInfo getUserByUsername(@PathVariable("username") String username);
  @RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
  public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);
  @RequestMapping(value = "/permissions", method = RequestMethod.GET)
  List<PermissionInfo> getAllPermissionInfo();*/
}