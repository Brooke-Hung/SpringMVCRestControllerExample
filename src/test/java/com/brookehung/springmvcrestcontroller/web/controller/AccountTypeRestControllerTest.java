package com.brookehung.springmvcrestcontroller.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.brookehung.springmvcrestcontroller.entity.AccountType;
import com.brookehung.springmvcrestcontroller.entity.AccountTypeEntitySearchCriteria;
import com.brookehung.springmvcrestcontroller.service.AccountTypeService;

public class AccountTypeRestControllerTest extends BaseControllerTest {

	private static final String URL_ACCOUNT_TYPES_1 = "/accountTypes/1";

	private static final String URL_ACCOUNT_TYPES = "/accountTypes";

	private static final Integer ACCOUNT_TYPE_ID = 1;

	@Autowired
	private AccountTypeService accountTypeService;

	private AccountType accountType;

	@Test
	public void testGetByIdSuccess() throws Exception {
		createAccount();
		Mockito.when(accountTypeService.getById(accountType.getTypeId())).thenReturn(accountType);
		mockMvc.perform(get(URL_ACCOUNT_TYPES_1).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.typeId").value(String.valueOf(accountType.getTypeId())))
				.andExpect(jsonPath("$.name").value(String.valueOf(accountType.getName())));
	}

	@Test
	public void testGetByIdFailure() throws Exception {
		Mockito.when(accountTypeService.getById(ACCOUNT_TYPE_ID)).thenReturn(null);
		mockMvc.perform(get(URL_ACCOUNT_TYPES_1)).andExpect(status().isNotFound());
	}

	@Test
	public void testDeleteByIdUnsupported() throws Exception {
		mockMvc.perform(delete(URL_ACCOUNT_TYPES_1)).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void testInsertUnsupported() throws Exception {
		mockMvc.perform(post(URL_ACCOUNT_TYPES)).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void testUpdateUnsupported() throws Exception {
		mockMvc.perform(put(URL_ACCOUNT_TYPES_1)).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void testSearchWithResults() throws Exception {
		createAccount();
		Mockito.when(accountTypeService.search(Mockito.any(AccountTypeEntitySearchCriteria.class)))
				.thenReturn(Arrays.asList(new AccountType[] { accountType }));
		mockMvc.perform(get(URL_ACCOUNT_TYPES).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.[0].typeId").value(String.valueOf(accountType.getTypeId())))
				.andExpect(jsonPath("$.[0].name").value(String.valueOf(accountType.getName())));
	}

	@Test
	public void testSearchWithoutResults() throws Exception {
		Mockito.when(accountTypeService.search(Mockito.any(AccountTypeEntitySearchCriteria.class))).thenReturn(Collections.EMPTY_LIST);
		mockMvc.perform(get(URL_ACCOUNT_TYPES).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound());
	}

	private void createAccount() {
		accountType = new AccountType();
		accountType.setTypeId(ACCOUNT_TYPE_ID);
		accountType.setName("Type 1");
	}

}
