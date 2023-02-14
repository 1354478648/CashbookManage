package com.sues.dao;

import com.sues.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username")String username,@Param("password")String password);

    @Update("update user set name = #{name} where id = #{id}")
    void updateName(@Param("name")String name,@Param("id")String id);

    @Update("update user set password = #{password} where id = #{id}")
    void updatePassword(@Param("password")String password,@Param("id")String id);

    @Select("select password from user where id = #{id}")
    String getOriginPassword(@Param("id")String id);
}
