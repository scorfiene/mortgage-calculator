package com.ing.test.mortgagecalculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ing.test.mortgagecalculator.application.controller.MortgageController;
import com.ing.test.mortgagecalculator.service.MortgageService;

/******************************************************************************
 * This class is used for checking the integration tests
 * 
 * @author Hari
 *
 *****************************************************************************/
@RunWith(SpringRunner.class)
@WebMvcTest(MortgageController.class)
@AutoConfigureWebMvc
public class MortgageCalculatorIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MortgageController controller;
	
	@MockBean
	private MortgageService service;
	
	@Test
	public void testEndpoints() throws Exception {
		
		this.mockMvc.perform(
				get("/api/interest-rates")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());		
	}


}
