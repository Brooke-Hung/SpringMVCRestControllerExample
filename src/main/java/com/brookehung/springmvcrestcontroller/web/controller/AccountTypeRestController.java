package com.brookehung.springmvcrestcontroller.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brookehung.springmvcrestcontroller.dto.AccountTypeSearchCriteria;
import com.brookehung.springmvcrestcontroller.entity.AccountType;
import com.brookehung.springmvcrestcontroller.entity.AccountTypeEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountTypeService;
import com.brookehung.springmvcrestcontroller.service.Service;

/**
 * RestController for AccountType
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
@RestController
@RequestMapping("/accountTypes")
public class AccountTypeRestController extends BaseReadOnlyRestController<AccountType, Integer, AccountTypeSearchCriteria, AccountTypeEntitySearchCriteria>{

	@Autowired
	private AccountTypeService accountTypeService;

	@Override
	protected Service<AccountType, AccountTypeEntitySearchCriteria, Integer> getService() {
		return accountTypeService;
	}

	@Override
	protected AccountTypeEntitySearchCriteria convertSCToESC(AccountTypeSearchCriteria sc) {
		AccountTypeEntitySearchCriteria accountTypeEntitySearchCriteria = new AccountTypeEntitySearchCriteria();
		if (sc != null) {
			accountTypeEntitySearchCriteria.setTypeId(sc.getTypeId());
			accountTypeEntitySearchCriteria.setName(sc.getName());
		}
		return accountTypeEntitySearchCriteria;
	}

}
