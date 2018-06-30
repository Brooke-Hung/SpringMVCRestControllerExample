package com.brookehung.springmvcrestcontroller.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brookehung.springmvcrestcontroller.dto.AccountSearchCriteria;
import com.brookehung.springmvcrestcontroller.entity.Account;
import com.brookehung.springmvcrestcontroller.entity.AccountEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountService;
import com.brookehung.springmvcrestcontroller.service.Service;

/**
 * RestController for Account
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController extends BaseRestController<Account, Long, AccountSearchCriteria, AccountEntitySearchCriteria>{

	@Autowired
	private AccountService accountService;

	@Override
	protected Service<Account, AccountEntitySearchCriteria, Long> getService() {
		return accountService;
	}

	@Override
	protected AccountEntitySearchCriteria convertSCToESC(AccountSearchCriteria sc) {
		AccountEntitySearchCriteria accountEntitySearchCriteria = new AccountEntitySearchCriteria();
		if (sc != null) {
			accountEntitySearchCriteria.setAccountId(sc.getAccountId());
			accountEntitySearchCriteria.setUserName(sc.getKeyword());
			accountEntitySearchCriteria.setRegistrationTimeFrom(sc.getRegistrationTimeFrom());
			accountEntitySearchCriteria.setRegistrationTimeTo(sc.getRegistrationTimeTo());
		}
		return accountEntitySearchCriteria;
	}

}
