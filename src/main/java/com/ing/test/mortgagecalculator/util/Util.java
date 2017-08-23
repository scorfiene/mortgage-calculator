package com.ing.test.mortgagecalculator.util;

/******************************************************************************
 * This class represents the commonly used methods to check the validations on
 * amounts
 * 
 * @author Hari
 *
 *****************************************************************************/
public class Util {
	
	/**
	 * Method to check validity of amounts which are mostly
	 * double. The check is for zero and negative values.
	 * 
	 * @param amount
	 * @return boolean
	 */
	public static boolean checkValidAmount (double amount) {
		if (amount > 0.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check validity of amounts which are mostly
	 * integer. The check is for zero and negative values.
	 * 
	 * @param number
	 * @return boolean
	 */
	public static boolean checkValidNumber (int number) {
		if (number > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
