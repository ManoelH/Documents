package com.springproject.comercial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {

	@RequestMapping(value = {"/documents/new"})
	public String newDocument() {
		return "RegisterDocument";
	}
	
}
