package com.ibm.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.exception.ValueMismatchException;
import com.ibm.model.CurrencyConverstionModel;
import com.ibm.service.CurrencyConverstionService;


@RestController
@RequestMapping("/curencyConvert")
public class CurrencyConverstionController {
	
	@Autowired
	CurrencyConverstionService currencyConversionService;
	
	
	
	  @GetMapping("/{countryCode}") 
	  public CurrencyConverstionModel getCurrnecyConvertionByCountryCode(@PathVariable String countryCode) {
	  
		  CurrencyConverstionModel currencyConverstionModel=currencyConversionService.getCurrnecyConvertionByCountryCode(countryCode);
	  if(currencyConverstionModel.equals(null))
	  {
		  throw new NullPointerException();
	  }
		  return currencyConverstionModel;
	  }
	 
	
	
	@PostMapping
	public ResponseEntity<CurrencyConverstionModel>  addCurrencyConverstion(@Valid @RequestBody CurrencyConverstionModel currencyConverstionModel)
	{
		CurrencyConverstionModel result = currencyConversionService.addTodo(currencyConverstionModel);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getCountryCode()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	@PutMapping("/{countryCode}")
	public ResponseEntity<CurrencyConverstionModel> updateCurrencyFactor(@PathVariable String countryCode,  @RequestBody CurrencyConverstionModel currencyConverstionModel) throws ValueMismatchException
	{
		if(!countryCode.equals(currencyConverstionModel.getCountryCode()))
		{
			throw new ValueMismatchException("error");
		}
		CurrencyConverstionModel result = currencyConversionService.updateTodo(currencyConverstionModel);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getCountryCode()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	
	

}
