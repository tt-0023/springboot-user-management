package com.luna.myfirstcrud;

import com.luna.myfirstcrud.entity.Users;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Users> {
    @Select("SELECT * FROM users WHERE id = #{id}")
    Users selectUserById(@Param("id") int id);
    @Select("SELECT * FROM users")
    List<Users> selectAllUser();
    @Insert("INSERT INTO users (name, age, phone,password) VALUES (#{name}, #{age}, #{phone},#{password})")
    int insertUser(Users user);
    @Update("UPDATE users SET name = #{name}, age = #{age}, phone = #{phone} WHERE id = #{id}")
    int updateUser(Users user);
    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteUser(@Param("id") int id);
    @Select("SELECT *FROM users")
    List<Users> getUserByPage();
    @Select("SELECT * FROM users WHERE name = #{name}")
    Users selectUserByName(@NotBlank(message = "用户名不能为空") String username);
}
