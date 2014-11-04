package com.beiying.petshop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.beiying.petshop.pojo.Account;
import com.beiying.petshop.service.AccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAction extends BaseAction<Account>{
	

	private static final long serialVersionUID = -1090412174493182180L;
	private static final String MAIN = "main";
	private static final String QUERY_ACCOUNT = "queryAccount";
	private static final String UPDATE_ACCOUNT = "updateAccount";
	
	public String save(){
		accountService.save(model);
		return MAIN;
	}
	
	public String query(){
		List<Account> accounts = accountService.query();
//		ActionContext.getContext().put("accounts", accounts);
//		ServletActionContext.getRequest().setAttribute("accounts", accounts);
		request.put("accounts", accounts);
		return QUERY_ACCOUNT;
	}
	
	public String get() {
//		ServletActionContext.getRequest().setAttribute("accounts", accountService.get(model.getAid()));
		request.put("accounts", accountService.get(model.getAid()));
		return UPDATE_ACCOUNT;
	}
	public String delete(){
		accountService.delete(model.getAid());
		
		List<Account> accounts = accountService.query();
//		ActionContext.getContext().put("accounts", accounts);
//		ServletActionContext.getRequest().setAttribute("accounts", accounts);
		request.put("accounts", accounts);
		return QUERY_ACCOUNT;
	}
	
	public String update(){
		accountService.update(model);
		return MAIN;
	}


}
