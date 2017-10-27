package com.skg.service.admin.rest;

import com.skg.service.admin.biz.AdminBiz;
import com.skg.service.core.exception.InvalidePasswordException;
import com.skg.service.core.exception.ParameterErrorException;
import com.skg.service.core.exception.UserNotFoundException;
import com.skg.service.core.model.Admin;
import com.skg.service.core.msg.ObjectRestResponse;
import com.skg.service.core.rest.BaseController;
import com.skg.service.core.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController extends BaseController<AdminBiz,Admin> {

    @Autowired
    private AdminBiz adminBiz;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(String username, String password) throws Exception {
        Admin admin = new Admin();

        admin.setMobile(username);
       /* admin.setUsername(
                username
        );*/
        admin.setPassword(password);
        Admin admin1 = adminBiz.getUserByCondition(admin);
        if(admin1 ==null)
            return ResponseEntity.status(404).body("{}");
        else
            return ResponseEntity.ok(admin1);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> loginUser(HttpServletRequest request, Admin admin) throws Exception {
        System.out.println(request.getSession().getId());
        if(StringUtils.isEmpty(admin.getUsername()) || StringUtils.isEmpty(admin.getPassword())){
            throw new ParameterErrorException("parameter error!");
        }
        Admin res = adminBiz.getUserByCondition(admin);
        if(res == null){
            throw new UserNotFoundException("user not find!");
        }
        //判断密码是否错误
        if(encoder.matches(admin.getPassword(), res.getPassword())){
            res.setPassword(null);
            ObjectRestResponse o = new ObjectRestResponse<Admin>();
            o.data(res);
            o.setStatus(200);
            return ResponseEntity.ok(o);
        }else{
            throw new InvalidePasswordException("invalide password");
        }
    }
}
