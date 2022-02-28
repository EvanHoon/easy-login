package com.rwh.sanxingdui.entity;

import lombok.Data;

/**
 * @description: 用户pojo类
 * @className: com.rwh.sanxingdui.pojo.User
 * @author: Wenhao.Ren
 * @create: 2021/12/14 13:26
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
