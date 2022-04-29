package com.ibm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exception.CurrencyConverstionNotFoundException;
import com.ibm.model.CurrencyConverstionModel;
import com.ibm.repository.CurrencyConverstionRepository;

@Service
public class CurrencyConverstionService {

	@Autowired
	CurrencyConverstionRepository currencyConverstionRepository;
	
	public CurrencyConverstionModel getCurrnecyConvertionByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return currencyConverstionRepository.findByCountryCode(countryCode);
	}

	public CurrencyConverstionModel addTodo(CurrencyConverstionModel currencyConverstionModel) {
		// TODO Auto-generated method stub
			return currencyConverstionRepository.saveAndFlush(currencyConverstionModel);
		
	}

	public CurrencyConverstionModel updateTodo(CurrencyConverstionModel currencyConverstionModel) {
		// TODO Auto-generated method stub
		
		getCurrnecyConvertionByCountryCode(currencyConverstionModel.getCountryCode());
		return currencyConverstionRepository.saveAndFlush(currencyConverstionModel);
	}
	
	

}
