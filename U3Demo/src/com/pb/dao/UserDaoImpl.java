package com.pb.dao;


import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.pb.base.dao.GenericHibernateDao;
import com.pb.domain.User;
@Repository("userDao")
public class UserDaoImpl extends GenericHibernateDao<User, Integer> implements UserDao {
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		final String hql = "from User u where u.name = '" +name+"'";
		return  getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return (User) session.createQuery(hql).uniqueResult();
			}
		});
	}

	@Override
	public List<User> findByPermission(Integer permission) {
		String hql = "from User u where u.permission = "+permission;
		return getHibernateTemplate().find(hql);
	}
	
	
}
