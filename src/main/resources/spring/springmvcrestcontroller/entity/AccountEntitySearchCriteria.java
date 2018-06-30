package com.brookehung.springmvcrestcontroller.entity;

import java.util.Date;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public class AccountEntitySearchCriteria implements EntitySearchCriteria {

	private Long accountId;
	
	private String userName;
	
	private Date registrationTimeFrom;
	
	private Date registrationTimeTo;

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

	public Date getRegistrationTimeFrom() {
		return registrationTimeFrom;
	}

	public void setRegistrationTimeFrom(Date registrationTimeFrom) {
		this.registrationTimeFrom = registrationTimeFrom;
	}

	public Date getRegistrationTimeTo() {
		return registrationTimeTo;
	}

	public void setRegistrationTimeTo(Date registrationTimeTo) {
		this.registrationTimeTo = registrationTimeTo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSearchCriteria [accountId=");
		builder.append(accountId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", registrationTimeFrom=");
		builder.append(registrationTimeFrom);
		builder.append(", registrationTimeTo=");
		builder.append(registrationTimeTo);
		builder.append("]");
		return builder.toString();
	}

}
