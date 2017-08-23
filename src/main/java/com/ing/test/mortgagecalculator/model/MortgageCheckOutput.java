package com.ing.test.mortgagecalculator.model;

/******************************************************************************
 * This class represents the output object after checking the feasibility of 
 * the mortgage.
 * 
 * @author Hari
 *
 *****************************************************************************/
public class MortgageCheckOutput {
	
	private boolean isFeasible;
	private double monthlyAmount;
	private Message message;
	
	public MortgageCheckOutput (boolean isFeasible,
			                    double monthlyAmount,
			                    Message message) {
		this.isFeasible = isFeasible;
		this.monthlyAmount = monthlyAmount;
		this.message = message;
	}

	/**
	 * @return the isFeasible
	 */
	public boolean isFeasible() {
		return isFeasible;
	}

	/**
	 * @return the monthlyAmount
	 */
	public double getMonthlyAmount() {
		return monthlyAmount;
	}

	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}
	

}
