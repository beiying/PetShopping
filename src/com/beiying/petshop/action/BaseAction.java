package com.beiying.petshop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.beiying.petshop.pojo.Account;
import com.beiying.petshop.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * 所有Action的业务逻辑
 * @author beiying
 *
 * @param <T>
 */


public class BaseAction<T> extends ActionSupport implements ModelDriven<T>, RequestAware, SessionAware, ApplicationAware{

	protected AccountService accountService = null;
	
	
	protected T model = null;
	protected Map<String, Object> request = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> application = null;
	
	public BaseAction(){
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		} 
	}
	
	public void setAccountService(AccountService accountService){
		this.accountService = accountService;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	/**
	 * 在创建Action之后通过通过拦截器
	 * 有了该方法,jsp中可以直接引用属性值
	 */
	@Override
	public T getModel() {
		return model;
	}

}
