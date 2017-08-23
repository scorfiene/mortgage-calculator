package com.ing.test.mortgagecalculator.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ing.test.mortgagecalculator.service.MortgageService;

/******************************************************************************
 * This class is the used as configuration for the beans used
 * 
 * @author Hari
 *
 *****************************************************************************/
@Configuration
public class MortgageConfig {

	@Bean(name="mortgageService")
	public MortgageService getService() {
		return new MortgageService();
	}
}
