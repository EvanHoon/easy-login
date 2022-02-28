package com.rwh.sanxingdui.service.serviceImpl;

import com.rwh.sanxingdui.mapper.UserMapper;
import com.rwh.sanxingdui.entity.User;
import com.rwh.sanxingdui.service.UserService;
import com.rwh.sanxingdui.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: com.rwh.sanxingdui.service.serviceImpl.UserServiceImpl
 * @author: Wenhao.Ren
 * @create: 2021/12/14 14:01
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录校验
     *
     * @param user
     * @return boolean
     */
    @Override
    public boolean login(User user) {
        String inputPsw = user.getPassword();
        String md5DB = userMapper.selectPswByName(user.getUsername()); // 查询数据库md5密码
        if (md5DB == null || inputPsw == null) {
            return false;
        }
        return MD5Utils.passwordIsTrue(inputPsw, md5DB);// 校验密码是否正确 返回
    }

    /**
     * 用户注册
     *
     * @param user
     * @return boolean
     */
    @Override
    public boolean register(User user) {
        String InputName = user.getUsername();// 获取用户名
        User DBUser = userMapper.selectByUsername(InputName); // 查询数据库是否存在该用户
        if (DBUser != null) {
            log.info("该用户名已存在");
            return false;
        }
        String MD5Psw = MD5Utils.string2MD5(user.getPassword()); //获取md5加密的密码
        userMapper.insertUser(new User(InputName, MD5Psw)); //注册用户
        return true;
    }


    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
