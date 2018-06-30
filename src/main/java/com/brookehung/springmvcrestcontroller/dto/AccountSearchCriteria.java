package com.brookehung.springmvcrestcontroller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
public class AccountSearchCriteria implements SearchCriteria {

	private Long accountId;
	
	private String keyword;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date registrationTimeFrom;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date registrationTimeTo;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append(", registrationTimeFrom=");
		builder.append(registrationTimeFrom);
		builder.append(", registrationTimeTo=");
		builder.append(registrationTimeTo);
		builder.append("]");
		return builder.toString();
	}

}
