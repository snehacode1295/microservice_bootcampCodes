package com.ibm.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class CurrencyConverstionModel {


	@Id
	@GeneratedValue
	private UUID id;
	
	@NotBlank(message = "Country Code cannot be null or empty")
	@Size(min = 3, max = 10, message = "Country Code must be b/w 3-10 characters")
	@Column(unique = true)
	private String countryCode;
	
	private double conversionFactor;

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

	public CurrencyConverstionModel(UUID id, String countryCode, double conversionFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	

	public CurrencyConverstionModel() {
		super();
	}

	@Override
	public String toString() {
		return "CurrencyConverstionModel [id=" + id + ", countryCode=" + countryCode + ", ConversionFactor="
				+ conversionFactor + "]";
	}
	
}
