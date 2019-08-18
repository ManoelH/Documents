package com.springproject.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.documents.model.Document;

public interface Documents extends JpaRepository<Document, Long> {

}
