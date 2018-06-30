package com.brookehung.springmvcrestcontroller.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.brookehung.springmvcrestcontroller.entity.AccountCertificate;
import com.brookehung.springmvcrestcontroller.service.AccountCertificateService;

public class AccountCertificateRestControllerTest extends BaseControllerTest {

	private static final String URL_ACCOUNTS_1_CERTIFICATE = "/accounts/1/certificate";

	private static final long ACCOUNT_ID = 1l;

	@Autowired
	private AccountCertificateService accountCertificateService;

	private AccountCertificate accountCertificate;

	@Test
	public void testGetByIdSuccess() throws Exception {
		createAccount();
		Mockito.when(accountCertificateService.getById(accountCertificate.getAccountId()))
				.thenReturn(accountCertificate);
		mockMvc.perform(get(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.accountId").value(String.valueOf(accountCertificate.getAccountId())))
				.andExpect(jsonPath("$.identity").value(String.valueOf(accountCertificate.getIdentity())))
				.andExpect(jsonPath("$.passport").value(String.valueOf(accountCertificate.getPassport())));
	}

	@Test
	public void testGetByIdFailure() throws Exception {
		Mockito.when(accountCertificateService.getById(ACCOUNT_ID)).thenReturn(null);
		mockMvc.perform(get(URL_ACCOUNTS_1_CERTIFICATE)).andExpect(status().isNotFound());
	}

	@Test
	public void testDeleteByIdSuccess() throws Exception {
		Mockito.when(accountCertificateService.delete(ACCOUNT_ID)).thenReturn(RESULT_SUCCESS);
		mockMvc.perform(delete(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_SUCCESS_IN_STRING));
	}

	@Test
	public void testDeleteByIdFailure() throws Exception {
		Mockito.when(accountCertificateService.delete(ACCOUNT_ID)).thenReturn(RESULT_FAILURE);
		mockMvc.perform(delete(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_FAILURE_IN_STRING));
	}

	@Test
	public void testInsertSuccess() throws Exception {
		Mockito.when(accountCertificateService.insert(Mockito.any(AccountCertificate.class))).thenReturn(ACCOUNT_ID);
		mockMvc.perform(post(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(ACCOUNT_ID));
	}

	@Test
	public void testInsertFailure() throws Exception {
		Mockito.when(accountCertificateService.insert(Mockito.any(AccountCertificate.class))).thenReturn(null);
		mockMvc.perform(post(URL_ACCOUNTS_1_CERTIFICATE)).andExpect(status().isInternalServerError());
	}

	@Test
	public void testUpdateSuccess() throws Exception {
		Mockito.when(accountCertificateService.update(Mockito.any(AccountCertificate.class)))
				.thenReturn(RESULT_SUCCESS);
		mockMvc.perform(put(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_SUCCESS_IN_STRING));
	}

	@Test
	public void testUpdateFailure() throws Exception {
		Mockito.when(accountCertificateService.update(Mockito.any(AccountCertificate.class)))
				.thenReturn(RESULT_FAILURE);
		mockMvc.perform(put(URL_ACCOUNTS_1_CERTIFICATE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$").value(RESULT_FAILURE_IN_STRING));
	}

	@Test
	public void testSearchWithResults() throws Exception {
		createAccount();
		mockMvc.perform(get("/accounts/1/certificate/unsupported")).andExpect(status().isMethodNotAllowed());
	}

	private void createAccount() {
		accountCertificate = new AccountCertificate();
		accountCertificate.setAccountId(ACCOUNT_ID);
		accountCertificate.setIdentity("111111");
		accountCertificate.setPassport("E222222");
	}

}
