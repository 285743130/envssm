package com.pb.dao;

import java.util.List;

import com.pb.base.dao.GenericDao;
import com.pb.domain.User;

public interface UserDao extends GenericDao<User, Integer> {
	public User findByName(String name);
	public List<User> findByPermission(Integer permission);
}
