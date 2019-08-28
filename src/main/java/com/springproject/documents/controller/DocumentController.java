package com.springproject.documents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		modelAndView.addObject(new Document());
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView ListDocuments() {
		List<Document> listDocuments = this.documents.findAll();
		ModelAndView modelAndView = new ModelAndView("ListDocuments");
		modelAndView.addObject("allDocuments", listDocuments);
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Document document, Errors erros, RedirectAttributes attributes) {
		if(erros.hasErrors())
			return "RegisterDocument";
		 
		attributes.addFlashAttribute("message", "Document saved with success!");
		documents.save(document);
		return "redirect:/documents/new";
	}
	
}

