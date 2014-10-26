package com.beiying.petshop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.beiying.petshop.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	protected HibernateTemplate hibernateTemplate;
	
	private Class<T> clazz = null;
	
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
		 
	}

	public void setHibernateTemplate(HibernateTemplate mHibernateTemplate) {
		this.hibernateTemplate = mHibernateTemplate;
	}

	@Override
	public void save(T t) {
		hibernateTemplate.save(t);
	}

	@Override
	public void update(T t) {
		hibernateTemplate.update(t);
	}

	@Override
	public T get(int id) {
		return hibernateTemplate.get(clazz, id);
	}

	@Override
	public List<T> query() {
		return hibernateTemplate.find("FROM " + clazz.getSimpleName());
	}

	@Override
	public void delete(int id) {
		Object obj = hibernateTemplate.get(clazz, id);
		if(obj != null){
			hibernateTemplate.delete(obj);
		}
	}

}
