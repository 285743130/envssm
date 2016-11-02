package com.pb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pb.dao.UserDao;
import com.pb.domain.User;
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	UserDao userDao;
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean userIsExists(String name, String password) {
		// TODO Auto-generated method stub
		User user = userDao.findByName(name);
		boolean flag = false;
		if(null != user ){
			if(password.equals(user.getPassword())){
				flag = true;
			}
		}
		return flag;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll() ;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	@Override
	public List<User> findByPermission(Integer permission) {
		// TODO Auto-generated method stub
		return userDao.findByPermission(permission);
	}

}
