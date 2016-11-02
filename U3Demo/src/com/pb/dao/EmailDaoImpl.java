package com.pb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pb.base.dao.GenericHibernateDao;
import com.pb.domain.Email;
@Repository("emailDao")
public class EmailDaoImpl extends GenericHibernateDao<Email, Integer> implements EmailDao {
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> findByUser(Integer id,Integer isDelete) {
		String hql = "from Email e where e.reciver.id = " + id +" and e.isDelete = "+isDelete;
		return getHibernateTemplate().find(hql);
	}
}
