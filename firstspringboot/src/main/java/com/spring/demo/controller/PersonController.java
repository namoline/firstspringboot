package com.spring.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.dao.PersonRepository;
import com.spring.demo.model.Person;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personneRepository;
	
	@GetMapping(value="/addPerson")
	public ModelAndView addPerson(ModelAndView mv) {
	mv.setViewName("AddPerson") ;
	return mv;
	}
	
	@PostMapping(value="/addPerson")
	public ModelAndView addPerson(@RequestParam Map<String,String> requestParams,ModelAndView mv) {
		
		
		String nom=requestParams.get("nom");
		String prenom=requestParams.get("prenom");
		
		Person p1= new Person(nom,prenom);
		personneRepository.save(p1);
		
		mv.setViewName("confirm");
		mv.addObject("nom", nom);
		mv.addObject("prenom", prenom);
		return mv;
		
		}
}
