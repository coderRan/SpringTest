package com.zdr.entity;

public class User {
	private String account;
	private String pwd;
	
	public User() {
		
	}

	public User(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", pwd=" + pwd + "]";
	}
	
	
	
}
