package com.sanjiv.spring.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CRMCustomExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CRMCustomExceptionMapping> handleException(CustomerNotFoundException customerNotFoundException) {
		
		CRMCustomExceptionMapping crmCustomExceptionMapping = new CRMCustomExceptionMapping();
		crmCustomExceptionMapping.setStatusCode(HttpStatus.NOT_FOUND.toString());
		crmCustomExceptionMapping.setMessage(customerNotFoundException.getMessage());
		crmCustomExceptionMapping.setDate(new Date());
		
		return new ResponseEntity<>(crmCustomExceptionMapping, HttpStatus.NOT_FOUND);
		
	}
	
		@ExceptionHandler
		public ResponseEntity<CRMCustomExceptionMapping> handleException(Exception ecxception) {
		
		CRMCustomExceptionMapping crmCustomExceptionMapping = new CRMCustomExceptionMapping();
		crmCustomExceptionMapping.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		crmCustomExceptionMapping.setMessage(ecxception.getMessage());
		crmCustomExceptionMapping.setDate(new Date());
		
		return new ResponseEntity<>(crmCustomExceptionMapping, HttpStatus.BAD_REQUEST);
		
	}

}
