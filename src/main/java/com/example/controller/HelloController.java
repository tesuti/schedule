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

import com.example.Person;
import com.example.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Controller
public class HelloController {
	  @Autowired
	  PersonRepository repository;

	//カレンダーデータをすべて表示
	  @RequestMapping("/create")
	  public ModelAndView index(
	      @ModelAttribute("formModel") Person Person,
	      ModelAndView mav) {

	    List<Person> list = repository.findAll();
	    mav.addObject("data",list);
	    return mav;
	  }
	  
	  //カレンダーを登録
	  @RequestMapping(value = "/create", method = RequestMethod.POST)
	  @Transactional
	  public ModelAndView form(
		      @ModelAttribute("formModel") Person Person, 
		      ModelAndView mav) {
		  repository.saveAndFlush(Person);
		  return new ModelAndView("redirect:/create");
	  }
	  //IDを取得
	  @RequestMapping(value="/edit/{id}",method= RequestMethod.GET )
	  public ModelAndView edit(@ModelAttribute Person Person,
			  @PathVariable int id, ModelAndView mav) {
		  Optional<Person> data = repository.findById((long)id);
		  mav.addObject("formModel", data.get());
		  return mav;
		  
	  }
	  
	  @RequestMapping(value="/edit",method= RequestMethod.POST )
	  @Transactional
	  public ModelAndView update(@ModelAttribute Person Person,
			  ModelAndView mav) {
		  repository.saveAndFlush(Person);
		  return new ModelAndView("redirect:/");
	  }


}