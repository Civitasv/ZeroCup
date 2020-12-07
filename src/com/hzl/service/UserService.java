package com.hzl.service;

import java.util.List;

import com.hzl.model.User;
import com.hzl.query.UserQuery;

public interface UserService extends  BaseService<User, UserQuery> {

	public User getUserByUsername(String username);
	
	public boolean findLogin(User user);
	
}
