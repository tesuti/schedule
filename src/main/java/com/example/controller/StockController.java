package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Person;
import com.example.repository.PersonRepository;
import com.example.search.CalendarService;

@Controller
@RequestMapping("/schedulelist")
public class StockController {
	@Autowired
	PersonRepository repository;
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	UserDetailsService userDetailsService;
	//全件表示
	@GetMapping
	public ModelAndView schedule(ModelAndView mav,
			@ModelAttribute("formModel") Person Person,Principal principal,Model model
			 ) {
		   UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
		List<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	   @PostMapping
	public ModelAndView select(@ModelAttribute("formModel") Person person, Model model,ModelAndView mav,Principal principal) {
		   UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
		List<Person> result = calendarService.search(person.getTitle(), person.getStart(), person.getEnd());
		mav.addObject("data", result);
		
		return mav;
	}
}
