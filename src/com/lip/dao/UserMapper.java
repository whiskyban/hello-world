package com.lip.dao;

import com.lip.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();
    User selectUserByNP(@Param("username")String username,@Param("pwd")String pwd);
    User selectUserByNP1(Map<String,Object>map);



    @Select("select id,name,pwd from user")
    List<User> getAllUser();
    @Select("select *from user where id=#{id}")
    User selectUserById(@Param("id")int id);
    @Insert("insert into user(id,name,pwd)values(#{id},#{name},#{pwd})")
    int addUser(User user);
    @Update("update user set pwd=#{pwd} where id=#{id}")
    int upDateUser(User user);
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id")int id);





}
