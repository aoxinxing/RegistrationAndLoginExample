package com.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	public void delete(User user) {
		this.hibernateTemplate.delete(user);
	}

	public void insert(User user) {
		this.hibernateTemplate.save(user);
	}

	public User query(String email) {
		String hql = "from User user where user.email=:n";
		List<User> users = this.hibernateTemplate.findByNamedParam(hql, "n",email);
		User user = null;
		if (users != null && users.size() > 0) {
			user = users.get(0);
		} else {
			System.out.println("query():users.size=" + users.size());
		}
		return user;
	}

	public List<User> query() {
		String hql = "from User user";
		List<User> users = this.hibernateTemplate.find(hql);
		return users;
	}

	public User update(User user) {
		this.hibernateTemplate.update(user);
		return this.query(user.getEmail());
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
