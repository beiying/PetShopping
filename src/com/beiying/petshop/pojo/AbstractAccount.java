package com.beiying.petshop.pojo;

/**
 * AbstractAccount entity provides the base persistence definition of the
 * Account entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAccount implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String alogin;
	private String aname;
	private String apass;

	// Constructors

	/** default constructor */
	public AbstractAccount() {
	}

	/** full constructor */
	public AbstractAccount(String alogin, String aname, String apass) {
		this.alogin = alogin;
		this.aname = aname;
		this.apass = apass;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAlogin() {
		return this.alogin;
	}

	public void setAlogin(String alogin) {
		this.alogin = alogin;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApass() {
		return this.apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

}