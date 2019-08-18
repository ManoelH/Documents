package com.springproject.documents.enums;

public enum StatusDocument {

	PENDENTE("PE"),
	PAGO("PA"),
	VENCIDO("VE");
	
	private String status;
	
	StatusDocument(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
}
