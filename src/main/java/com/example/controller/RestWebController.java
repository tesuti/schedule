package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Person;
import com.example.repository.PersonRepository;

@RestController
@RequestMapping("/api/event")
public class RestWebController {
	   @Autowired
	    private PersonRepository personRepository;
	   
	//カレンダーデータをすべて表示
    @GetMapping(value = "/all")
    public List<Person> getEvents() {
        List<Person> events = personRepository.findAll();
        return events;
    }
}
