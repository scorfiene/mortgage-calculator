package com.ing.test.mortgagecalculator.util;

import java.util.ArrayList;
import java.util.List;
import com.ing.test.mortgagecalculator.model.MortgageRate;

/******************************************************************************
 * This class represents the data preparation for the initial load of interest
 * rates.
 * 
 * @author Hari
 *
 *****************************************************************************/
public class MortgageRateDataLoad {
	
	/**
	 * This method adds the interest rate values in the form of 
	 * MortgageRate objects to the list 
	 * 
	 * @return
	 */
	public static List<MortgageRate> prepareMortgageRates()  {		
		List<MortgageRate> rates = new ArrayList<MortgageRate>();
		
		rates.add(new MortgageRate(1, 500.0, 1483309243));
		rates.add(new MortgageRate(12, 495.0, 1485987643));
		rates.add(new MortgageRate(50, 400.0, 1488406843));
		rates.add(new MortgageRate(180, 350.0, 1493677243));
		rates.add(new MortgageRate(360, 10.0, 1501626043));

		return rates;
	}
	
	
	
	
	

}
