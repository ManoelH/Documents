package com.springproject.documents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.documents.enums.StatusDocument;
import com.springproject.documents.model.Document;
import com.springproject.documents.repository.Documents;

@Service
public class DocumentService {
	
	@Autowired
	private Documents documents;
	
	public void saveDocument(Document document) {
		documents.save(document);
	}
	
	
	public void deleteDocumentById(Long id) {
		documents.deleteById(id);
	}
	
	public void toGetDocument(Document document) {
		document.setStatus(StatusDocument.PAID);
		documents.save(document);
	}
}
