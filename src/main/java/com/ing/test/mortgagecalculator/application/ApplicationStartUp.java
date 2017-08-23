package com.ing.test.mortgagecalculator.application;

import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ing.test.mortgagecalculator.model.MortgageRate;
import com.ing.test.mortgagecalculator.service.MortgageService;

/******************************************************************************
 * This class helps in loading the List of MortgageRate objects to be loaded
 * in memory and prints it to console. The run() method of ApplicationRunner
 * is overriden and the Service class is invoked with has the rates 
 * prepared
 * 
 * @author Hari
 *
 *****************************************************************************/
@Component
public class ApplicationStartUp implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		MortgageService service = new MortgageService();
		List<MortgageRate> rates = service.getInterestRates();
		rates.stream().forEach(rate -> 
			System.out.println("interest rate = "+rate.getInterestRate()+ ", " +
					           "maturity period = "+rate.getMaturityPeriod()+ ", " +
					           "last update ="+new Date(rate.getLastUpdate())));
		
	}

	
}
