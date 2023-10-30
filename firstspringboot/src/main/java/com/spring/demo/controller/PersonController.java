package com.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(value="/search")
	public ModelAndView searchPerson(ModelAndView mv) {
	mv.setViewName("search") ;
	return mv;
	}
	
	@RequestMapping(value="/simplesearch")
	public ModelAndView showAllSorted() {
	List<Person> personnes = personneRepository.findAll(Sort.by("nom").descending());
	ModelAndView mv = new ModelAndView();
	mv.setViewName("search");
	mv.addObject("tab", personnes);
	return mv;
	}
	
	@RequestMapping(value="/advancedSearch")
	public ModelAndView showSome(@RequestParam(value ="nom") String nom, @RequestParam(value = "prenom") String prenom) {
			ArrayList <Person> al =(ArrayList<Person>)
			personneRepository.findByNomAndPrenom(nom,
			prenom);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("search");
			mv.addObject("tab", al);
			return mv;
	}
}
