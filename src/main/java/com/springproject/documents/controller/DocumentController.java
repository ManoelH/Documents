package com.springproject.documents.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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

	private static final String REGISTER_DOCUMENT_VIEW = "RegisterDocument";
	private static final String LIST_DOCUMENTS_VIEW = "ListDocuments";
	
	@Autowired
	private Documents documents;
	
	@RequestMapping("/new")
	public ModelAndView newDocument() {
		ModelAndView modelAndView = new ModelAndView(REGISTER_DOCUMENT_VIEW);
		modelAndView.addObject("allStatus", StatusDocument.values());
		modelAndView.addObject(new Document());
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView ListDocuments() {
		List<Document> listDocuments = this.documents.findAll();
		ModelAndView modelAndView = new ModelAndView(LIST_DOCUMENTS_VIEW);
		modelAndView.addObject("allDocuments", listDocuments);
		return modelAndView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Document document, Errors erros, RedirectAttributes attributes) {
		if(erros.hasErrors())
			return REGISTER_DOCUMENT_VIEW;
		 
		attributes.addFlashAttribute("message", "Document saved with success!");
		documents.save(document);
		return "redirect:/documents/new";
	}
	
	@RequestMapping("/{id}")
	public ModelAndView put(@PathVariable("id") Document document) {
		ModelAndView modelAndView = new ModelAndView(REGISTER_DOCUMENT_VIEW);
		modelAndView.addObject(document);
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		documents.deleteById(id);
		return "redirect:/documents/list";
	}
	
}

