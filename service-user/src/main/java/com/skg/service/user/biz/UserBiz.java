package com.skg.service.user.biz;

import com.skg.service.core.biz.BaseBiz;
import com.skg.service.core.model.User;
import com.skg.service.core.util.PhoneFormatCheckUtils;

import com.skg.service.user.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserBiz extends BaseBiz<UserMapper,User> {

    /*@Autowired
    private UserAuthUtil userAuthUtil;*/
    @Override
    public void insertSelective(User entity) {
        //String password = new BCryptPasswordEncoder(12).encode(entity.getPassword());
        String password = new BCryptPasswordEncoder().encode(entity.getPassword());//有参数 形式生成 慢
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(User entity) {

        if( !StringUtils.isEmpty(entity.getPassword())){
            String password = new BCryptPasswordEncoder().encode(entity.getPassword());
            entity.setPassword(password);
        }
//        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword())
//        entity.setPassword(password);
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }
    /**
     * 通过手机号获取用户信息
     */
    public User getUserByMobile(String mobile){
        User user = new User();
        user.setMobile(mobile);
        return mapper.selectOne(user);
    }

    public User getUserByCondition(User user ){
        if(PhoneFormatCheckUtils.isPhoneLegal(user.getMobile())){
            return getUserByMobile(user.getMobile());
        }else{
            return getUserByUsername(user.getUsername());
        }
    }

}
