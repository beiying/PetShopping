package com.beiying.petshop.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beiying.petshop.pojo.Account;
import com.beiying.petshop.service.AccountService;

public class AccountServiceImplTest {

	private static AccountService sAccountService = null;
	private static ClassPathXmlApplicationContext sApplicationContext = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sApplicationContext = new  ClassPathXmlApplicationContext("applicationContext-*.xml");
		sAccountService = (AccountService) sApplicationContext.getBean("accountService");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sAccountService = null;
		sApplicationContext.destroy();
	}

	@Test
	public void testSave() {
		Account account = new Account();
		account.setAid(7);
		account.setAlogin("test7");
		account.setAname("test7");
		account.setApass("1237");
		sAccountService.save(account);
	}

	@Test
	public void testUpdate() {
		Account account = sAccountService.get(5);
		account.setAname("test577");
		sAccountService.update(account);
	}

	@Test
	public void testGet() {
		Account account = sAccountService.get(5);
		System.out.println(account.getAname());
	}

	@Test
	public void testQuery() {
		List<Account> accounts = sAccountService.query();
		for (Account account : accounts) {
			System.out.println(account.getAname());
		}
	}

	@Test
	public void testDelete() {
		sAccountService.delete(5);
	}

}
