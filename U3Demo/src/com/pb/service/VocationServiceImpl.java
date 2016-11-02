package com.pb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pb.dao.UserDao;
import com.pb.dao.VocationDao;
import com.pb.domain.User;
import com.pb.domain.Vocation;
@Service("vocationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VocationServiceImpl implements VocationService {
	VocationDao vocationDao;
	@Resource(name = "vocationDao")
	public void setVocationDao(VocationDao vocationDao) {
		this.vocationDao = vocationDao;
	}
	UserDao userDao;
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public Vocation findById(Integer id) {
		// TODO Auto-generated method stub
		return vocationDao.findById(id);
	}

	@Override
	public List<Vocation> findAll() {
		// TODO Auto-generated method stub
		return vocationDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addVocation(Vocation vocation, User applier, Integer approverId) {
		// TODO Auto-generated method stub
		User approver = userDao.findById(approverId);
		vocation.setApplier(applier);
		vocation.setApprover(approver);
		vocationDao.save(vocation);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateState(Integer id,Integer state) {
		// TODO Auto-generated method stub
		Vocation vocation = vocationDao.findById(id);
		vocation.setState(state);
		vocationDao.update(vocation);
	}


	@Override
	public List<Vocation> findByUser(User user) {
		// TODO Auto-generated method stub
		return vocationDao.findByApplierId(user.getId());
	}


	@Override
	public List<Vocation> findByApprover(User user) {
		// TODO Auto-generated method stub
		return vocationDao.findByApproverId(user.getId());
	}



}
