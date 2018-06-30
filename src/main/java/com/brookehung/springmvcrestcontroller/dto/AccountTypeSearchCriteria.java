package com.brookehung.springmvcrestcontroller.dto;

/**
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
public class AccountTypeSearchCriteria implements SearchCriteria {

	private Integer typeId;
	
	private String name;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountTypeSearchCriteria [typeId=");
		builder.append(typeId);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
