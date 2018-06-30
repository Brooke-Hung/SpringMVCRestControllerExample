package com.brookehung.springmvcrestcontroller.service.impl;

import org.springframework.stereotype.Service;

import com.brookehung.springmvcrestcontroller.entity.Account;
import com.brookehung.springmvcrestcontroller.entity.AccountEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountService;

/**
 * Implementation for Account Service with CRUD operations from BaseService
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
@Service
public class AccountServiceImpl extends BaseService<Account, AccountEntitySearchCriteria, Long> implements AccountService {

}
