package com.ing.test.mortgagecalculator;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.ing.test.mortgagecalculator.application.controller.MortgageController;
import com.ing.test.mortgagecalculator.model.MortgageCheckInput;
import com.ing.test.mortgagecalculator.model.MortgageCheckOutput;
import com.ing.test.mortgagecalculator.model.MortgageRate;
import com.ing.test.mortgagecalculator.service.MortgageService;

/******************************************************************************
 * This class contains the unit tests on the apis
 * 
 * @author Hari
 *
 ******************************************************************************/
@RunWith(SpringRunner.class)
@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {
	
	@Autowired
	private MortgageService service;
	
	@TestConfiguration
	static class MortgageControllerTestConfiguration {
		
		@Bean
		public MortgageService mortgageService() {
			return new MortgageService();
		}
	}
	
	/**
	 * Positive test that invokes the functionality of getInterestRates
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_getInterestRates() throws Exception {
		List<MortgageRate> rates = service.getInterestRates();
		rates.stream().forEach(rate -> 
			System.out.println("interest rate = "+rate.getInterestRate()+ ", " +
					           "maturity period = "+rate.getMaturityPeriod()+ ", " +
					           "last update ="+new Date(rate.getLastUpdate())));
		Assert.assertTrue(rates.size()>0);
	}
	
	/**
	 * Positive test that invokes the checkMortgageFeasibility with value of
	 * isFeasible false returned
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageFalse() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(2500, 14, 200000, 3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(false, output.isFeasible());
		Assert.assertTrue(output.getMonthlyAmount() > 0.0);
		Assert.assertEquals(0, output.getMessage().getResponseCode());
		
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());
		System.out.println("Mortgage amount: "+output.getMonthlyAmount());
	}
	
	/**
	 * Positive test that invokes the checkMortgageFeasibility with value of
	 * isFeasible true returned
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageTrue() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(4500, 6, 10000, 3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(true, output.isFeasible());
		Assert.assertTrue(output.getMonthlyAmount() > 0.0);
		Assert.assertEquals(0, output.getMessage().getResponseCode());
		
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());
		System.out.println("Mortgage amount: "+output.getMonthlyAmount());
		
	}
	
	/**
	 * Negative test that invokes the checkMortgageFeasibility with invalid
	 * value of income
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageInvalidIncome() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(-2, 6, 10000, 3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(-1, output.getMessage().getResponseCode());
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());

	}
	
	/**
	 * Negative test that invokes the checkMortgageFeasibility with invalid
	 * value of maturity period
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageInvalidMaturityPeriod() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(2000, -6, 10000, 3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(-1, output.getMessage().getResponseCode());
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());

	}
	
	/**
	 * Negative test that invokes the checkMortgageFeasibility with invalid
	 * value of loan value
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageInvalidLoanValue() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(2000, 6, 0, 3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(-1, output.getMessage().getResponseCode());
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());

	}
	
	/**
	 * Negative test that invokes the checkMortgageFeasibility with invalid
	 * value of home value
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageInvalidHomeValue() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(2000, 6, 10000, -3000, 80.0);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(-1, output.getMessage().getResponseCode());
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());

	}
	
	/**
	 * Negative test that invokes the checkMortgageFeasibility with invalid
	 * value of interest rate
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_checkMortgageInvalidInterestRate() throws Exception {
		
		MortgageCheckInput input = new MortgageCheckInput(2000, 6, 10000, 3000, -3);
		MortgageCheckOutput output = service.checkMortgageFeasible(input);

		Assert.assertEquals(-1, output.getMessage().getResponseCode());
		System.out.println("Response Message: "+output.getMessage().getResponseMessage());

	}
	
}
