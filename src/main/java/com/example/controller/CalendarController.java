package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.model.Model;

@Controller
public class CalendarController {
	@RequestMapping(path = "/calendar", method = RequestMethod.GET)
	String index(Model model) {
		return "calendar/index";
	}
}
