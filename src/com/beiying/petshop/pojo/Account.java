package com.beiying.petshop.pojo;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
public class Account extends AbstractAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String alogin, String aname, String apass) {
		super(alogin, aname, apass);
	}

}
