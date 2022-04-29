package com.ibm.model;

import java.util.UUID;


public class ConvertedModel {
	
private UUID id;
	
	
	private String countryCode;
	
	private double conversionFactor;
	private double amount;
	private double converrtedAmount;
	public ConvertedModel(UUID id, String countryCode, double conversionFactor, double amount,
			double converrtedAmount) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		this.converrtedAmount = converrtedAmount;
	}
	public ConvertedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getConverrtedAmount() {
		return converrtedAmount;
	}
	public void setConverrtedAmount(double converrtedAmount) {
		this.converrtedAmount = converrtedAmount;
	}
	@Override
	public String toString() {
		return "ConvertedModel [id=" + id + ", countryCode=" + countryCode + ", conversionFactor=" + conversionFactor
				+ ", amount=" + amount + ", converrtedAmount=" + converrtedAmount + "]";
	}

}
