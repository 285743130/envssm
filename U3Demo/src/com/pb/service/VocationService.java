package com.pb.service;

import java.util.List;

import com.pb.domain.User;
import com.pb.domain.Vocation;

public interface VocationService {
	/**
	 * 根据id查找请假信息
	 * @param id 
	 * @return 请假信息
	 */ 
	public Vocation findById(Integer id);
	/**
	 * 根据用户查找该用户的请假信息
	 * @param user 用户
	 * @return 用户的请假信息的集合
	 */
	public List<Vocation> findByUser(User user);
	/**
	 * 查找所有用户的请假信息
	 * @return 所有用户的请假信息的集合
	 */
	public List<Vocation> findAll();
	/**
	 * 用户申请请假的方法
	 * @param vocation 请假信息
	 * @param applier 申请者
	 * @param approverId 审批者的id
	 */
	public void addVocation(Vocation vocation,User applier,Integer approverId);
	/**
	 * 修改假条的状态
	 * @param state 假条的状态
	 */
	public void updateState(Integer id,Integer state);
	public List<Vocation> findByApprover(User user);
	
	
}
