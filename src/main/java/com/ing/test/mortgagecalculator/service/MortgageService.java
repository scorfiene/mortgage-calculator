package com.ing.test.mortgagecalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ing.test.mortgagecalculator.model.Message;
import com.ing.test.mortgagecalculator.model.MortgageCheckInput;
import com.ing.test.mortgagecalculator.model.MortgageCheckOutput;
import com.ing.test.mortgagecalculator.model.MortgageRate;
import com.ing.test.mortgagecalculator.util.Constants;
import com.ing.test.mortgagecalculator.util.MortgageRateDataLoad;
import com.ing.test.mortgagecalculator.util.Util;

/******************************************************************************
 * This class contains the logic for the services behind the apis described in
 * the controller. With the load of this class, the set of predefined interest
 * rates are loaded. The same is returned using the service getInterestRates.
 * The checkMortgageFeasible method contains the logic to calculate the 
 * mortgage amount based on the input provided and then to check whether the 
 * amount is feasible or not by undergoing the checks for the amount.
 * 
 * @author Hari
 *
 *****************************************************************************/
@Service("mortgageService")
public class MortgageService {
	
	private static List<MortgageRate> mortgageRates = new ArrayList<MortgageRate>();
	
	/**
	 * This loads the initial list of predifined interest rates
	 */
	static {
		mortgageRates = MortgageRateDataLoad.prepareMortgageRates();
	}
	
	/**
	 * The method returns the mortgageRates object which is a list of
	 * MortgageRate objects having the maturityPeriod, interestRate 
	 * and lastUpdate parameters
	 * 
	 * @return List<MortgageRate>
	 */
	public List<MortgageRate> getInterestRates() {
		return mortgageRates;
	}
	
	/**
	 * This method takes MortgageCheckInput as input and uses the parameters to 
	 * calculate the mortgage amount after validating the input fields. Then 
	 * the amount is checked for feasibility. Message and error code are 
	 * formulated accordingly. The output is MortgageCheckOutput which contains 
	 * the error code, error message, flag to check feasibility and the mortgage
	 * amount
	 * 
	 * @param input
	 * @return MorgageCheckOutput
	 */
	public MortgageCheckOutput checkMortgageFeasible (MortgageCheckInput input) {
		
		MortgageCheckOutput output = null;
		boolean isFeasible = true;
		Message message = null;
		double mortgage = 0.0;
		
		message = validateMortgageCheckInput(input);
		if (null == message) {
		
			mortgage = calculateMortgage(input);
		
			if (mortgage > 4*(input.getIncome())) {
				isFeasible = false;
			}
			if (mortgage > input.getHomeValue()) {
				isFeasible = false;
			}
			
			if (isFeasible) {
				message = new Message(0, Constants.MES_VALID_MORT_FEASIBLE);
			} else {
				message = new Message(0, Constants.MES_VALID_MORT_NOTFEASIBLE);
			}
		}
		output = new MortgageCheckOutput(isFeasible, mortgage, message);
		return output;
		
	}
	
	/**
	 * This method validates the input fields of MortgageCheckInput. Normally
	 * the amounts mentioned are checked for zero and negative figures.
	 * The Message object is created accordingly.
	 * 
	 * @param input
	 * @return Message
	 */
	private Message validateMortgageCheckInput (MortgageCheckInput input) {
		
		Message message = null;
		if (!Util.checkValidAmount(input.getHomeValue())) {
			message = new Message(-1, Constants.MES_INVALID_HOMEVALUE);
		}
		if (!Util.checkValidAmount(input.getIncome())) {
			message = new Message(-1, Constants.MES_INVALID_INCOME);
		}
		if (!Util.checkValidAmount(input.getInterestRate())) {
			message = new Message(-1, Constants.MES_INVALID_INTERESTRATE);
		}
		if (!Util.checkValidAmount(input.getLoanValue())) {
			message = new Message(-1, Constants.MES_INVALID_LOANVALUE);
		}
		if (!Util.checkValidNumber(input.getMaturityPeriod())) {
			message = new Message(-1, Constants.MES_INVALID_MATURITYPERIOD);
		}
		return message;
	}
	
	/**
	 * This method is used for calculating the mortage amount
	 * 
	 * @param input
	 * @return double
	 */
	private double calculateMortgage (MortgageCheckInput input) {
		
		double mortgage = 0.0;
		
		double loan = input.getLoanValue();
		int period = input.getMaturityPeriod();
		double interest = input.getInterestRate();
		
		period *= 12;
		interest /= 1200;
		
		mortgage = (loan * interest * Math.pow(1+interest, period))
				  /(Math.pow(1+interest, period) - 1);
		
		return mortgage;
	}

}
