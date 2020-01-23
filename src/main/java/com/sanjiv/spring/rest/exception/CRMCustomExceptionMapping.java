package com.sanjiv.spring.rest.exception;

import java.util.Date;

public class CRMCustomExceptionMapping {
	
	private String statusCode;
	private String message;
	private Date date;
	
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
