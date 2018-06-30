package com.brookehung.springmvcrestcontroller.service.impl;

import org.springframework.stereotype.Service;

import com.brookehung.springmvcrestcontroller.entity.AccountType;
import com.brookehung.springmvcrestcontroller.entity.AccountTypeEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountTypeService;

/**
 * Implementation for Account Type Service with CRUD operations from BaseService
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/28
 */
@Service
public class AccountTypeServiceImpl extends BaseService<AccountType, AccountTypeEntitySearchCriteria, Integer> implements AccountTypeService {

}
