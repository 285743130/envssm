package com.pb.dao;



import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pb.base.dao.GenericHibernateDao;
import com.pb.domain.Vocation;
@Repository("vocationDao")
public class VocationDaoImpl extends GenericHibernateDao<Vocation, Integer> implements VocationDao {
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vocation> findByApplierId(Integer applierId) {
		// TODO Auto-generated method stub
		String hql = "from Vocation v where v.applier.id = "+applierId;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<Vocation> findByApproverId(Integer approverId) {
		// TODO Auto-generated method stub
		String hql = "from Vocation v where v.approver.id = "+approverId;
		return getHibernateTemplate().find(hql);
	}


}
