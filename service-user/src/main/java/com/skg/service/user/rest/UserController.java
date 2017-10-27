package com.skg.service.user.rest;

import com.skg.service.core.exception.InvalidePasswordException;
import com.skg.service.core.exception.ParameterErrorException;
import com.skg.service.core.exception.UserNotFoundException;
import com.skg.service.core.model.User;
import com.skg.service.core.msg.ObjectRestResponse;
import com.skg.service.core.rest.BaseController;
import com.skg.service.core.util.PasswordUtil;
import com.skg.service.user.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz,User> {

    @Autowired
    private UserBiz userBiz;

    /*@Autowired
    private PermissionService permissionService;*/

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(User user) throws Exception {
        User u = userBiz.getUserByCondition(user);
        if(u ==null)
            return ResponseEntity.status(404).body("{}");
        else
            return ResponseEntity.ok(u);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> createUser(User user) throws Exception {
        //FrontUser userInfo = permissionService.getUserInfo(token);
        userBiz.insertSelective(user);
        if(user.getId() != null && user.getId()!= 0)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.status(500).body(false);

    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> loginUser(HttpServletRequest request, User user) throws Exception {

        System.out.println(request.getSession().getId());

        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            throw new ParameterErrorException("parameter error!");
        }
        User res = userBiz.getUserByCondition(user);
        if(res == null){
            throw new UserNotFoundException("user not find!");
        }
        //判断密码是否错误
        if(PasswordUtil.decodePassword(res.getPassword()).equals(user.getPassword())){
            res.setPassword(null);
            ObjectRestResponse o = new ObjectRestResponse<User>();
            o.data(res);
            o.setStatus(200);
            return ResponseEntity.ok(o);
        }else{
            throw new InvalidePasswordException("invalide password");
        }
    }
}
