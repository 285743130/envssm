package com.pb.service;

import java.util.List;

import com.pb.domain.User;

public interface UserService {
	/***
	 * 判断用户是否存在
	 * @param name 用户名
	 * @param password 密码
	 * @return 如果用户存在，放回true,否则返回false
	 */
	public boolean userIsExists(String name,String password);
	/***
	 * 修改用户信息
	 * @param user 修改
	 */
	public void UpdateUser(User user);
	/**
	 * 根据id查找用户
	 * @param id
	 * @return 用户对象
	 */
	public User findById(Integer id);
	/**
	 * 查找所有的用户
	 * @return 用户的集合
	 */
	public List<User> findAll();
	
	public void addUser(User user);
	public User findByName(String name);
	public List<User> findByPermission(Integer permission);
	
}
