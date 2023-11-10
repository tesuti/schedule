package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Calendar;
import com.example.repository.CalendarRepository;

import jakarta.transaction.Transactional;

@Controller
public class HelloController {
	  @Autowired
	  CalendarRepository repository;

	//カレンダーデータをすべて表示
	  @RequestMapping("/create")
	  public ModelAndView index(
	      @ModelAttribute("formModel") Calendar Calendar,
	      ModelAndView mav) {

	    List<Calendar> list = repository.findAll();
	    mav.addObject("data",list);
	    return mav;
	  }
	  
	  //カレンダーを登録
	  @RequestMapping(value = "/create", method = RequestMethod.POST)
	  @Transactional
	  public ModelAndView form(
		      @ModelAttribute("formModel") Calendar Calendar, 
		      ModelAndView mav) {
		  repository.saveAndFlush(Calendar);
		  return new ModelAndView("redirect:/create");
	  }
	  
	  @RequestMapping(value="/edit/{id}",method= RequestMethod.GET )
	  public ModelAndView edit(@ModelAttribute Calendar Calendar,
			  @PathVariable int id, ModelAndView mav) {
		  Optional<Calendar> data = repository.findById((long)id);
		  mav.addObject("formModel", data.get());
		  return mav;
		  
	  }
	  
	  @RequestMapping(value="/edit",method= RequestMethod.POST )
	  @Transactional
	  public ModelAndView update(@ModelAttribute Calendar Calendar,
			  ModelAndView mav) {
		  repository.saveAndFlush(Calendar);
		  return new ModelAndView("redirect:/");
	  }


}