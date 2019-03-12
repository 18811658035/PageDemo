package com.Dy.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Dy.Pojo.User;

public interface UserMapper {
	public List<User> findAllUsers();
	public User GetUserByNameAndPw(@Param("username")String username ,@Param("password")String password);
}
