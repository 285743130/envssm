package com.pb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pb.dao.EmailDao;
import com.pb.dao.UserDao;
import com.pb.domain.Email;
import com.pb.domain.User;

@Service("emailService")
@Transactional(propagation = Propagation.REQUIRED)
public class EmailServiceImpl implements EmailService {

	EmailDao emailDao;

	@Resource(name = "emailDao")
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	UserDao userDao;

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveEmail(Email email, User sender, Integer reciverId) {
		// TODO Auto-generated method stub
		User reciver = userDao.findById(reciverId);
		email.setSender(sender);
		email.setReciver(reciver);
		emailDao.save(email);

	}

	@Override
	public void updateIsRead(Integer id) {
		// TODO Auto-generated method stub
		Email email = emailDao.findById(id);
		email.setIsRead(1);
		emailDao.update(email);

	}

	@Override
	public void updateIsDelete(Integer id,int flag) {
		// TODO Auto-generated method stub
		Email email = emailDao.findById(id);
		email.setIsDelete(flag);
		emailDao.update(email);
	}

	@Override
	public void deleteEmail(Integer id) {
		// TODO Auto-generated method stub
		Email email = emailDao.findById(id);
		emailDao.delete(email);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Email findById(Integer id) {
		// TODO Auto-generated method stub
		return emailDao.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Email> findAll() {
		// TODO Auto-generated method stub
		return emailDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Email> findByUser(User user,Integer isDelete) {
		// TODO Auto-generated method stub
		return emailDao.findByUser(user.getId(),isDelete);
	}
	
	

}
