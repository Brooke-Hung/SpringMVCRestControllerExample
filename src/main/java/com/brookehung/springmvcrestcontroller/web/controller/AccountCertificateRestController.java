package com.brookehung.springmvcrestcontroller.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brookehung.springmvcrestcontroller.dto.DummySearchCriteria;
import com.brookehung.springmvcrestcontroller.entity.AccountCertificate;
import com.brookehung.springmvcrestcontroller.entity.DummyEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountCertificateService;
import com.brookehung.springmvcrestcontroller.service.Service;

/**
 * RestController for AccountCertificate
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
@RestController
@RequestMapping("/accounts/{id}/certificate")
public class AccountCertificateRestController extends BaseDetailsRestController<AccountCertificate, Long, DummySearchCriteria, DummyEntitySearchCriteria>{

	@Autowired
	private AccountCertificateService accountCertificateService;

	@Override
	protected Service<AccountCertificate, DummyEntitySearchCriteria, Long> getService() {
		return accountCertificateService;
	}

}
