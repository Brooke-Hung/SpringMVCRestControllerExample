package com.brookehung.springmvcrestcontroller.entity;

import java.util.Date;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public class Account {
	
	private Long accountId;
	
	private String userName;
	
	private String password;
	
	private Date registrationTime;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", registrationTime=");
		builder.append(registrationTime);
		builder.append("]");
		return builder.toString();
	}
	
}
