package com.brookehung.springmvcrestcontroller.web.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Base test case to initiate web context
 * @author Brooke
 * @since JDK1.8
 * @created on 2018/06/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/web-application-context.xml")
@WebAppConfiguration
public abstract class BaseControllerTest {

	protected static final int RESULT_SUCCESS = 1;

	protected static final int RESULT_FAILURE = 0;

	protected static final String RESULT_SUCCESS_IN_STRING = "1";

	protected static final String RESULT_FAILURE_IN_STRING = "0";

	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	

}
