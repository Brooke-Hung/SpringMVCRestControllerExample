package com.brookehung.springmvcrestcontroller.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.brookehung.springmvcrestcontroller.entity.Account;
import com.brookehung.springmvcrestcontroller.entity.AccountEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountService;

public class AccountRestControllerTest extends BaseControllerTest {

	private static final String URL_ACCOUNTS_1 = "/accounts/1";

	private static final String URL_ACCOUNTS = "/accounts";

	private static final Long ACCOUNT_ID = 1l;
	
	private static final Integer ACCOUNT_TYPE_ID = 1;

	private static final String APPLICATION_XML_UTF8_VALUE = "application/xml;charset=UTF-8";

	@Autowired
	private AccountService accountService;

	private Account account;

	@Test
	public void testGetByIdSuccess() throws Exception {
		mockAccount();
		mockMvc.perform(get(URL_ACCOUNTS_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.accountId").value(String.valueOf(account.getAccountId())))
				.andExpect(jsonPath("$.accountType").value(String.valueOf(account.getAccountType())))
				.andExpect(jsonPath("$.userName").value(String.valueOf(account.getUserName())))
				.andExpect(jsonPath("$.password").value(String.valueOf(account.getPassword())))
				.andExpect(
						jsonPath("$.registrationTime").value(String.valueOf(account.getRegistrationTime().getTime())));
	}

	@Test
	public void testGetByIdSuccessXML() throws Exception {
		mockAccount();
		mockMvc.perform(get(URL_ACCOUNTS_1).accept(APPLICATION_XML_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_XML_UTF8_VALUE))
				.andExpect(xpath("/Account/accountId").string(String.valueOf(account.getAccountId())))
				.andExpect(xpath("/Account/accountType").string(String.valueOf(account.getAccountType())))
				.andExpect(xpath("/Account/userName").string(String.valueOf(account.getUserName())))
				.andExpect(xpath("/Account/password").string(String.valueOf(account.getPassword())))
				.andExpect(xpath("/Account/registrationTime")
						.string(String.valueOf(account.getRegistrationTime().getTime())));
	}

	@Test
	public void testGetByIdFailure() throws Exception {
		Mockito.when(accountService.getById(ACCOUNT_ID)).thenReturn(null);
		mockMvc.perform(get(URL_ACCOUNTS_1)).andExpect(status().isNotFound());
	}

	@Test
	public void testDeleteByIdSuccess() throws Exception {
		Mockito.when(accountService.delete(ACCOUNT_ID)).thenReturn(RESULT_SUCCESS);
		mockMvc.perform(delete(URL_ACCOUNTS_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_SUCCESS_IN_STRING));
	}

	@Test
	public void testDeleteByIdFailure() throws Exception {
		Mockito.when(accountService.delete(ACCOUNT_ID)).thenReturn(RESULT_FAILURE);
		mockMvc.perform(delete(URL_ACCOUNTS_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_FAILURE_IN_STRING));
	}

	@Test
	public void testInsertSuccess() throws Exception {
		Mockito.when(accountService.insert(Mockito.any(Account.class))).thenReturn(ACCOUNT_ID);
		mockMvc.perform(post(URL_ACCOUNTS).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(ACCOUNT_ID));
	}

	@Test
	public void testInsertFailure() throws Exception {
		Mockito.when(accountService.insert(Mockito.any(Account.class))).thenReturn(null);
		mockMvc.perform(post(URL_ACCOUNTS)).andExpect(status().isInternalServerError());
	}

	@Test
	public void testUpdateSuccess() throws Exception {
		Mockito.when(accountService.update(Mockito.any(Account.class))).thenReturn(RESULT_SUCCESS);
		mockMvc.perform(put(URL_ACCOUNTS_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_SUCCESS_IN_STRING));
	}

	@Test
	public void testUpdateFailure() throws Exception {
		Mockito.when(accountService.update(Mockito.any(Account.class))).thenReturn(RESULT_FAILURE);
		mockMvc.perform(put(URL_ACCOUNTS_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_FAILURE_IN_STRING));
	}

	@Test
	public void testSearchWithResults() throws Exception {
		createAccount();
		Mockito.when(accountService.search(Mockito.any(AccountEntitySearchCriteria.class)))
				.thenReturn(Arrays.asList(new Account[] { account }));
		mockMvc.perform(get(URL_ACCOUNTS).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.[0].accountId").value(String.valueOf(account.getAccountId())))
				.andExpect(jsonPath("$.[0].accountType").value(String.valueOf(account.getAccountType())))
				.andExpect(jsonPath("$.[0].userName").value(String.valueOf(account.getUserName())))
				.andExpect(jsonPath("$.[0].password").value(String.valueOf(account.getPassword())))
				.andExpect(jsonPath("$.[0].registrationTime")
						.value(String.valueOf(account.getRegistrationTime().getTime())));
	}

	@Test
	public void testSearchWithoutResults() throws Exception {
		Mockito.when(accountService.search(Mockito.any(AccountEntitySearchCriteria.class))).thenReturn(Collections.EMPTY_LIST);
		mockMvc.perform(get(URL_ACCOUNTS).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound());
	}

	private void mockAccount() {
		createAccount();
		Mockito.when(accountService.getById(account.getAccountId())).thenReturn(account);
	}

	private void createAccount() {
		account = new Account();
		account.setAccountId(ACCOUNT_ID);
		account.setAccountType(ACCOUNT_TYPE_ID);
		account.setUserName("User Name");
		account.setPassword("password");
		Date now = new Date();
		account.setRegistrationTime(now);
	}

}
