package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Calendar;
import com.example.repository.CalendarRepository;

@RestController
@RequestMapping("/api/event")
public class RestWebController {
	   @Autowired
	    private CalendarRepository calendarRepository;
	   
	//カレンダーデータをすべて表示
    @GetMapping(value = "/all")
    public List<Calendar> getEvents() {
        List<Calendar> events = calendarRepository.findAll();
        return events;
    }
}
