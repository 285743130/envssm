package com.pb.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.pb.domain.Page;

public class GenericHibernateDao<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDao<T, ID> {
	protected Class<?> entityClass;

	public GenericHibernateDao() {
		entityClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(entity);
	
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
	return (T) getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
	

		return getHibernateTemplate().find(" from "+getEntityClass().getName());
	}

	private static final int pageCount = 10;//每页显示的条数
	@SuppressWarnings("unchecked")
	@Override
	public Page findByPage(int currentPage, T entity) {
		StringBuffer sb = createSQL(entity);

		final String countSQL = "select count(*) " + sb.toString();
		final String listSQL = sb.toString();

		int totalNumber = 0;
		final int from = (currentPage - 1) * pageCount;
		List<T> list = null;
		Long count = (Long) getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return (Long) session.createQuery(countSQL).uniqueResult();
			}
		});
		totalNumber = count.intValue();
		list=getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return session.createQuery(listSQL).setFirstResult(from)
						.setMaxResults(10).list();
			}
		});

		int totalPage = totalNumber % pageCount == 0 ? totalNumber / pageCount
				: totalNumber / pageCount + 1;

		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setTotalPage(totalPage);
		page.setTotalNumber(totalNumber);
		page.setList(list);

		return page;
		
	}
	protected StringBuffer createSQL(T entity) {
	
		return new StringBuffer(" from " + getEntityClass().getName());
	}

}
