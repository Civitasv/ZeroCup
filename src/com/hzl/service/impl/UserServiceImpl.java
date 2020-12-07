package com.hzl.service.impl;

import com.hzl.dao.UserDao;
import com.hzl.model.User;
import com.hzl.query.UserQuery;
import com.hzl.service.UserService;


public class UserServiceImpl extends BaseServiceImpl<User, UserQuery> implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		this.baseDao = userDao;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public boolean findLogin(User user) {
		return userDao.findLogin(user);
	}
}
