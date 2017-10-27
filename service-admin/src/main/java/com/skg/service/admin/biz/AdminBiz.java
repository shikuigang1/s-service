package com.skg.service.admin.biz;

import com.skg.service.admin.mapper.AdminMapper;
import com.skg.service.core.model.Admin;
import com.skg.service.core.util.PhoneFormatCheckUtils;

import com.skg.service.core.biz.BaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class AdminBiz extends BaseBiz<AdminMapper,Admin> {

    /*@Autowired
    private UserAuthUtil userAuthUtil;*/
    @Override
    public void insertSelective(Admin entity) {
        //String password = new BCryptPasswordEncoder(12).encode(entity.getPassword());
        String password = new BCryptPasswordEncoder().encode(entity.getPassword());//有参数 形式生成 慢
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    public void updateSelectiveById(Admin entity) {

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
    public Admin getUserByUsername(String username){
        Admin admin = new Admin();
        admin.setUsername(username);
        return mapper.selectOne(admin);
    }
    /**
     * 通过手机号获取用户信息
     */
    public Admin getUserByMobile(String mobile){
        Admin user = new Admin();
        user.setMobile(mobile);
        return mapper.selectOne(user);
    }

    public Admin getUserByCondition(Admin user ){
        if(!StringUtils.isEmpty(user.getMobile()) && PhoneFormatCheckUtils.isPhoneLegal(user.getMobile())){
            return getUserByMobile(user.getMobile());
        }else{
            return getUserByUsername(user.getUsername());
        }
    }
}
