package com.ing.test.mortgagecalculator.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ing.test.mortgagecalculator.model.MortgageCheckInput;
import com.ing.test.mortgagecalculator.model.MortgageCheckOutput;
import com.ing.test.mortgagecalculator.model.MortgageRate;
import com.ing.test.mortgagecalculator.service.MortgageService;

/******************************************************************************
 * This class is the controller for the application. This marks the entry point 
 * for the apis. There are 2 apis:
 * - /api/interest-rate  : GET
 * - /api/mortgage-check : POST
 * 
 * @author Hari
 *
 ******************************************************************************/
@RestController
@RequestMapping("/api")
public class MortgageController {
	
	@Autowired
	MortgageService service;
	
	/**
	 * Method for the api /interest-rates that provides a list of mortgage
	 * rate parameters including the maturityPeriod, interestRate and
	 * lastUpdate timestamp
	 * 
	 * @return List<MortgageRate>
	 */
	@RequestMapping (value="/interest-rates", method=RequestMethod.GET)
	public ResponseEntity<List<MortgageRate>> listInterestRates() {
		
		List<MortgageRate> interestRates = service.getInterestRates();
		if (null == interestRates || interestRates.isEmpty()) {
			return new ResponseEntity<List<MortgageRate>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MortgageRate>>(interestRates, HttpStatus.OK);
	}
	
	/**
	 * Method for the api /mortgage-check that takes a Json input containing
	 * the parameters described in MortgageCheckInput object and provides the 
	 * MortgageCheckOutput object containing the mortgageRate, flag which says
	 * whether mortgage is feasible or not, and also the message involving an 
	 * error code and message. The api first validates the input and then 
	 * undergoes the mortgage rate calculation. Based on the checks on the amount
	 * it is decided whether the rate is feasible or not.
	 * 
	 * @param input
	 * @param builder
	 * @return MortgageCheckOutput
	 */
	@RequestMapping (value="/mortgage-check", method=RequestMethod.POST)
	public ResponseEntity<MortgageCheckOutput> checkMortgage (
			                                @RequestBody MortgageCheckInput input,
			                                UriComponentsBuilder builder) {
		MortgageCheckOutput output = service.checkMortgageFeasible(input);
		if (null == output) {
			return new ResponseEntity<MortgageCheckOutput>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MortgageCheckOutput> (output, HttpStatus.OK);
	}

}
