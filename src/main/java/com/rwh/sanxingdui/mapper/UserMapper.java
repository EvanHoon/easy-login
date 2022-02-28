package com.rwh.sanxingdui.mapper;

import com.rwh.sanxingdui.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: com.rwh.sanxingdui.mapper.UserMapper
 * @author: Wenhao.Ren
 * @create: 2021/12/14 13:26
 */
@Mapper
public interface UserMapper {

    @Select("Select * from user")
    List<User> selectUsers();

    @Select("Select * from user where username=#{username}")
    User selectByUsername(@Param("username") String username);

    @Select("Select password from user where username=#{username}")
    String selectPswByName(@Param("username") String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insertUser(User user);

}
