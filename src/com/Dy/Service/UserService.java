package com.Dy.Service;

import com.Dy.Pojo.PageInfo;
import com.Dy.Pojo.User;

public interface UserService {
	public PageInfo<User> findAllUsersByPage(Integer currentPage,Integer pageSize);
	 public User GetUserByNameAndPw(String username,String password);
}
