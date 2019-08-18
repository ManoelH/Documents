package com.springproject.documents.enums;

public enum StatusDocument {

	PENDING("PE"),
	PAID("PA"),
	OVERDUE("OD");
	
	private String status;
	
	StatusDocument(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
}
