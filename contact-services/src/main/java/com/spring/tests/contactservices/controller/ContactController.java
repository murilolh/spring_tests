package com.spring.tests.contactservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tests.contactservices.dao.ContactDAO;
import com.spring.tests.contactservices.model.Contact;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private ContactDAO contactDao;

	@GetMapping
	public ModelAndView listar() {
		List<Contact> list = contactDao.findAll();

		ModelAndView modelAndView = new ModelAndView("contacts");
		modelAndView.addObject("contacts", list);

		return modelAndView;
	}

}
