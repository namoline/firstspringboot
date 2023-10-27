package com.spring.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	/*@RequestMapping(value="/hello", method = RequestMethod.GET)
	public void sayHello() {
	System.out.println("Hello World!");*/
	
	
	
	
	@GetMapping(value="/hello")
	public ModelAndView sayHello(ModelAndView mv) {
	mv.setViewName("hello") ;
	mv.addObject("nom", "Nancy");
	return mv;
	}

	@GetMapping(value="/hello2")
	public ModelAndView sayHello2(@RequestParam Map<String,String> requestParams,ModelAndView mv) {
	mv.setViewName("hello") ;
	
	String nom=requestParams.get("nom");
	String prenom=requestParams.get("prenom");
	
	mv.addObject("nom", nom+" "+prenom);
	return mv;
	}
}
