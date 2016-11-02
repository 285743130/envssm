package com.pb.service;

import java.util.List;

import com.pb.domain.Email;
import com.pb.domain.User;

public interface EmailService {
	/***
	 * 保存邮件
	 * @param email 邮件
	 * @param sender 发件者
	 * @param reciverId 收件者的id
	 */
	 public void saveEmail(Email email,User sender,Integer reciverId);
	 /**
	  * 将邮件变更为已读
	  * @param id 邮件id
	  */
	 public void updateIsRead(Integer id);
	 /**
	  * 将邮件放在垃圾箱
	  * @param id 邮件id
	  * @param flag 邮件的状态
	  */
	 public void updateIsDelete(Integer id,int flag);
	 /**
	  * 删除邮件
	  * @param id 邮件id
	  */
	 public void deleteEmail(Integer id);
	 /**
	  * 根据id查找邮件
	  * @param id 邮件id
	  * @return
	  */
	 public Email findById(Integer id);
	/**
	 * 查找所有用户的邮件
	 * @return
	 */
	 public List<Email> findAll();
	 /**
	  * 查找当前用户所有的邮件
	  * @param user 用户
	  * @param isDelete 邮件的状态
	  * @return 邮件的集合
	  */
	 public List<Email> findByUser(User user,Integer isDelete);
	 
}
