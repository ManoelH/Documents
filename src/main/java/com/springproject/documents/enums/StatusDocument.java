package com.springproject.documents.enums;

public enum StatusDocument {

	PENDING("Pending"),
	PAID("Paid"),
	OVERDUE("Overdue");
	
	private String status;
	
	StatusDocument(String status){
		this.status = status;
	}

	public String getStatus() {
		return status.toString();
	}
		
}
