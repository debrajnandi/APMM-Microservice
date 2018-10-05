package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@Controller
public class PersonController {

	@Autowired
	PersonDAO perDAO;
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addPerson")
	public String addPerson(Person per) {
		perDAO.save(per);
		return "home.jsp";
		
	}
	
	@RequestMapping("/getPerson")
	public ModelAndView addPerson(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showPerson.jsp");
		Person person = perDAO.findById(id).orElse(new Person());
		mv.addObject(person);
		return mv;
		
	}
}
