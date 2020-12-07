package com.hzl.utils;

import com.hzl.model.User;

import java.util.Map;


public class UserGet {

	public static User getUser(Map session) {
		Object obj = session.get("user");
		User user = null;
		if(obj!=null&&User.class.isInstance(obj)) {
			user = (User)obj;
		}
		return user;
	}
}
