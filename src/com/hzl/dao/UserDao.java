package com.hzl.dao;


import com.hzl.model.User;
import com.hzl.query.UserQuery;

public interface UserDao extends BaseDao<User, UserQuery>{
	public User getUserByUsername(String username);
	
	public boolean findLogin(User user);
}
