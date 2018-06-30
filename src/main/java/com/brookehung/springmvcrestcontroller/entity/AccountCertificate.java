package com.brookehung.springmvcrestcontroller.entity;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
public class AccountCertificate {
	
	private Long accountId;
	
	private String identity;
	
	private String passport;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountCertificate [accountId=");
		builder.append(accountId);
		builder.append(", identity=");
		builder.append(identity);
		builder.append(", passport=");
		builder.append(passport);
		builder.append("]");
		return builder.toString();
	}
	
}
