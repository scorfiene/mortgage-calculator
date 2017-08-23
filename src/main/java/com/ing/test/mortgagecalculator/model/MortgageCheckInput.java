package com.ing.test.mortgagecalculator.model;

/******************************************************************************
 * This class represents the input object for checking the feasibility of 
 * the mortgage.
 * 
 * @author Hari
 *
 *****************************************************************************/
public class MortgageCheckInput {
	
	private double income;
	private int maturityPeriod;
	private double loanValue;
	private double homeValue;
	private double interestRate;
	
	public MortgageCheckInput (double income,
			                   int maturityPeriod,
			                   double loanValue,
			                   double homeValue,
			                   double interestRate) {
		this.income = income;
		this.maturityPeriod = maturityPeriod;
		this.loanValue = loanValue;
		this.homeValue = homeValue;
		this.interestRate = interestRate;
	}

	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @return the maturityPeriod
	 */
	public int getMaturityPeriod() {
		return maturityPeriod;
	}

	/**
	 * @return the loanValue
	 */
	public double getLoanValue() {
		return loanValue;
	}

	/**
	 * @return the homeValue
	 */
	public double getHomeValue() {
		return homeValue;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	

}
