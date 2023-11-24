package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//全件表示
	   @GetMapping
	public String schedule(Model model,
			@ModelAttribute("formModel") Person Person
			 ) {

		List<Person> list = repository.findAll();
		model.addAttribute("data", list);
		return "schedulelist";
	}
	
	   @PostMapping
	public String select(@ModelAttribute("formModel") Person person, Model model) {
		
		List<Person> result = calendarService.search(person.getTitle(), person.getStart(), person.getEnd());
		model.addAttribute("data", result);
		
		return "schedulelist";
	}
}
