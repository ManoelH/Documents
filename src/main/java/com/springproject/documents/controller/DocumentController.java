package com.springproject.documents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {

	@RequestMapping("/documents/new")
	public String newDocument() {
		return "RegisterDocument";
	}
	
}

