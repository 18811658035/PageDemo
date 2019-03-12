package com.Dy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dy.Mapper.UserMapper;
import com.Dy.Pojo.PageInfo;
import com.Dy.Pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;

	@Override
	public PageInfo<User> findAllUsersByPage(Integer currentPage, Integer pageSize) {
		List<User> users = usermapper.findAllUsers();
		
		PageInfo<User> pageInfo = new PageInfo<>(users.size(), currentPage, pageSize, 5);
		
		//判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
		if(currentPage==pageInfo.getTotalPage())
			pageInfo.setList(users.subList((currentPage-1)*pageSize, users.size()));
		else 
			pageInfo.setList(users.subList((currentPage-1)*pageSize, (currentPage-1)*pageSize+pageSize));
		return pageInfo;
	}

	@Override
	public User GetUserByNameAndPw(String username, String password) {
		User user = usermapper.GetUserByNameAndPw(username, password);
		return user;
	}

}
