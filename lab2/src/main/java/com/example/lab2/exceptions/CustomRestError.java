package com.example.lab2.exceptions;

import java.util.Date;

public class CustomRestError {
	
	private Date date;
	private String error;
	private String label;
	
	public CustomRestError(Date date, String error, String label) {
		this.date = date;
		this.error = error;
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
