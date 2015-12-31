package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	public void insert(User user);

	public void delete(User user);

	public User update(User user);

	public User query(String username);

	public List<User> query();
}
