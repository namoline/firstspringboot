package com.spring.demo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.demo.TestJdbc;


@Controller
public class HomeController {
	//premières requetes d'apprentissage.
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
	
	@GetMapping(value="/testJdbc")
	public ModelAndView testeJdbc(ModelAndView mv) {
	mv.setViewName("TestJdbc") ;
	return mv;
	}
	
	
	
	@GetMapping(value="/testDatabase")
	public ModelAndView testDatabaseConnexion(@RequestParam Map<String,String> requestParams,ModelAndView mv) {
	
		final String SERVER="localhost";
		final String BD="SpringDemo";
		final String LOGIN="postgres";
		final String PASSWORD="admin";

	mv.setViewName("TestJdbc") ;
	String id=requestParams.get("id");
	
	TestJdbc jdbc = null;
	try {
	        jdbc = new TestJdbc();
	        jdbc.connect(SERVER, BD, LOGIN, PASSWORD);
	        if(id.equals("1")) {
	        mv.addObject("resultat", "OK");
	        }else {
	        	String sql="select count(*) as total from person";
	        	Connection con=jdbc.getConnexion();
	        	Statement stm=con.createStatement();
	        	ResultSet  rs=stm.executeQuery(sql);
	        	while(rs.next()){
	        	    int count = rs.getInt("total");
	        	    mv.addObject("resultat2", count);
	        	    }
	        }
	        jdbc.disconnect();
           
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("resultat", "KO");
			mv.addObject("resultat2", "KO");
			 try {
				jdbc.disconnect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	
	
	
	return mv;
	}
	
	
}
