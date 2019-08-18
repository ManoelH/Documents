package com.springproject.documents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.documents.model.Document;
import com.springproject.documents.repository.Documents;

@Controller
@RequestMapping("/documents")
public class DocumentController {

	@Autowired
	private Documents documents;
	
	@RequestMapping("/new")
	public String newDocument() {
		return "RegisterDocument";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(Document document) {
		documents.save(document);
		System.out.println("Registed with sucess");
		return "RegisterDocument";
	}
	
}

