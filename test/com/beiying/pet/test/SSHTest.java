package com.beiying.pet.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSHTest {
	
	/**
	 * 验证Spring框架导入包是否正确
	 */
	@Test
	public void spring(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context.getBean("date"));
		
		
	}
	/**
	 * 验证Hibernate导入包是否正确
	 */
	@Test
	public void hibernate(){
		System.out.println(HibernateSessionFactory.getSession());
	}
}
