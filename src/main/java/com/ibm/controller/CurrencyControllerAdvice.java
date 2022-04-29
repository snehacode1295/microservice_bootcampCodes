package com.ibm.controller;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.exception.ErrorDetails;
import com.ibm.exception.ValueMismatchException;

@RestControllerAdvice
public class CurrencyControllerAdvice {

	@ExceptionHandler(ValueMismatchException.class)
	public ResponseEntity<ErrorDetails> handleNotFound(ValueMismatchException e)
	{
		ErrorDetails ed = new ErrorDetails("Value Not Present", "Value is not Present in DB", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleInvalidTodo(MethodArgumentNotValidException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Invalid Data", "Data not matched with format", LocalDateTime.now());
		ed.setErrorFields(e.getFieldErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateData(DataIntegrityViolationException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Duplicate Data", "Country code already exist", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);	
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateData(NullPointerException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Empty", "Data doesnot exist", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);	
	}
	
}
