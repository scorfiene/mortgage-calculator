package com.ing.test.mortgagecalculator.model;

/******************************************************************************
 * This class represents the Message object to send back a code and a text
 * message back to the invoker
 * 
 * @author Hari
 *
 *****************************************************************************/
public class Message {
	
	private int responseCode;
	private String responseMessage;
	
	public Message (int responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}
	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}
	
	

}
