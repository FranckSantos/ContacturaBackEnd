package com.contactura.contactura.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactura.contactura.repository.ContacturaUserRepository;

@RestController
@RequestMapping({"/contacturauser"}) //http://localhost:8095/contacturauser
public class ContacturaUserController {
	
	@Autowired
	private ContacturaUserRepository repository;
	
//  List All - http://localhost:8095/contacturauser	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

}
