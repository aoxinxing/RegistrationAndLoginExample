package com.service;

import com.dao.UserDao;
import com.model.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public User find(String email) {
		User user = null;
		user = this.userDao.query(email);
		return user;
	}

	public void save(User user) {
		this.userDao.insert(user);
	}

	public User modify(User user) {
		return this.userDao.update(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
