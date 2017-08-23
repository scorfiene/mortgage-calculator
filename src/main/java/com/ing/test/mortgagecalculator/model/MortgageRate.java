package com.ing.test.mortgagecalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/******************************************************************************
 * This class represents the interest rates object 
 * 
 * @author Hari
 *
 *****************************************************************************/
public class MortgageRate {
	
	@JsonProperty("maturityPeriod")
	private int maturityPeriod;
	@JsonProperty("interestRate")
	private double interestRate;
	@JsonProperty("lastUpdate")
	private long lastUpdate;
	
	public MortgageRate (int maturityPeriod,
						 double interestRate,
						 long lastUpdate) {
		this.maturityPeriod = maturityPeriod;
		this.interestRate = interestRate;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the maturityPeriod
	 */
	public int getMaturityPeriod() {
		return maturityPeriod;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @return the lastUpdate
	 */
	public long getLastUpdate() {
		return lastUpdate;
	}
	
	

}
