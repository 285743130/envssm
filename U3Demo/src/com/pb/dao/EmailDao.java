package com.pb.dao;

import java.util.List;

import com.pb.base.dao.GenericDao;
import com.pb.domain.Email;

public interface EmailDao extends GenericDao<Email, Integer> {
	public List<Email> findByUser(Integer id,Integer isDelete);
}
