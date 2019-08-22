package com.springproject.documents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.documents.enums.StatusDocument;
import com.springproject.documents.model.Document;
import com.springproject.documents.repository.Documents;

@Controller
@RequestMapping("/documents")
public class DocumentController {

	@Autowired
	private Documents documents;
	
	@RequestMapping("/new")
	public ModelAndView newDocument() {
		ModelAndView modelAndView = new ModelAndView("RegisterDocument");
		modelAndView.addObject("allStatus", StatusDocument.values());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Document document) {
		documents.save(document);
		ModelAndView modelAndView = new ModelAndView("RegisterDocument");
		modelAndView.addObject("message", "Document saved with success!");
		return modelAndView;
	}
	
	//H2 URL jdbc:h2:mem:testdb
}

