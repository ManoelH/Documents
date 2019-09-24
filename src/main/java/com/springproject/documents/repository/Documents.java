package com.springproject.documents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.documents.model.Document;

public interface Documents extends JpaRepository<Document, Long> {

	public List<Document> findByDescriptionContaining(String description);
		
	
}
