package com.pb.dao;

import java.util.List;

import com.pb.base.dao.GenericDao;
import com.pb.domain.Vocation;

public interface VocationDao extends GenericDao<Vocation, Integer> {
	
	public List<Vocation> findByApplierId(Integer applierId);
	public List<Vocation> findByApproverId(Integer approverId);
}
