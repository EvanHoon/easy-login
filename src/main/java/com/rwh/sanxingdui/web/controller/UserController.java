package com.rwh.sanxingdui.web.controller;

import com.rwh.sanxingdui.entity.User;
import com.rwh.sanxingdui.service.UserService;
import com.rwh.sanxingdui.utils.MD5Utils;
import com.rwh.sanxingdui.utils.Message;
import com.rwh.sanxingdui.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @className: com.rwh.sanxingdui.web.controller.UserController
 * @author: Wenhao.Ren
 * @create: 2021/12/14 13:25
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Message login(User user, HttpSession session) {
        if (session.getAttribute("token") != null) {
            return MessageUtil.success("您已登录");
        }
        // 校验账号密码
        if (userService.login(user)) {
            String md5Psw = MD5Utils.string2MD5(user.getPassword());
            user.setPassword(md5Psw); //将user对象的密码改成md5加密的密码
            session.setAttribute("token", user); //对象存入session
            log.info("用户登录成功");
            return MessageUtil.success("用户登录成功!");
        }
        log.info("用户登录失败");
        return MessageUtil.redict("登录失败，请检查账号密码是否正确!");
    }

    @PostMapping("/register")
    public Message register(User user, HttpSession session) {
        if (userService.register(user)) {
            log.info("用户注册成功");
            return MessageUtil.success("用户注册成功，为您跳转到登录页面");
        }
        return MessageUtil.redict("登录失败，该用户名已存在!");
    }

    @PostMapping("/signout")
    public Message signout(HttpSession session) {
        if (session.getAttribute("token") != null) {
            session.removeAttribute("token");
            log.info("删除token，退出登录");
            return MessageUtil.success("用户已退出登录");
        }
        return MessageUtil.redict("未登录");
    }

    @GetMapping("/selectone")
    public User selectone(@RequestParam(value = "username") String username) {
        return userService.selectByUsername(username);
    }

    @PostMapping("/insert")
    public void insertUser(User user) {
        userService.insertUser(user);
    }

    @RequestMapping("/test")
    public String test() {
        return "hello test";
    }

}
