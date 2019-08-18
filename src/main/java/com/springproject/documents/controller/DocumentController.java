package com.springproject.documents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.documents.model.Document;

@Controller
@RequestMapping("/documents")
public class DocumentController {

	@RequestMapping("/new")
	public String newDocument() {
		return "RegisterDocument";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(Document document) {
		System.out.println("Testing");
		return "RegisterDocument";
	}
	
}

