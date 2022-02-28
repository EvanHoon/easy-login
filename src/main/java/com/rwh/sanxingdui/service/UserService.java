package com.rwh.sanxingdui.service;

import com.rwh.sanxingdui.entity.User;
import org.springframework.stereotype.Service;

/**
 * @className: com.rwh.sanxingdui.service.UserService
 * @author: Wenhao.Ren
 * @create: 2021/12/14 13:26
 */
@Service
public interface UserService {

    //登录
    boolean login(User user);

    // 注册
    boolean register(User user);

    User selectByUsername(String username);

    void insertUser(User user);
}
