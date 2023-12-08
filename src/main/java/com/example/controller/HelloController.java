package com.example.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Person;
import com.example.repository.PersonRepository;
import com.example.search.CalendarService;
import com.example.service.UserService;

import jakarta.transaction.Transactional;

@RequestMapping("/")
@Controller
public class HelloController {
	@Autowired
	PersonRepository repository;
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	@Autowired
	 private CalendarService calendarService;
	
	//カレンダーデータをすべて表示
	@RequestMapping("/create")
	public ModelAndView index(
			@ModelAttribute("formModel") Person Person,
			ModelAndView mav,Principal principal,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		List<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	//カレンダーを登録
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional
	public ModelAndView form(
			@ModelAttribute("formModel") @Validated Person Person,
			BindingResult result,
			ModelAndView mav, Principal principal,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		ModelAndView res = null;
		System.out.println(result.getFieldErrors());
		if (!result.hasErrors()) {
			repository.saveAndFlush(Person);
			res = new ModelAndView("redirect:/");
		} else {
			mav.setViewName("create");
			Iterable<Person> list = repository.findAll();
			mav.addObject("datalist", list);
			res = mav;
		}
		return res;
	}

	//IDを取得
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Person Person, Principal principal,
			@PathVariable int id, ModelAndView mav,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		mav.setViewName("edit");
		Optional<Person> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}


	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional
	public ModelAndView update(
			@ModelAttribute("formModel") @Validated Person Person,
			BindingResult result,
			ModelAndView mav, Principal principal,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		ModelAndView res = null;
		System.out.println(result.getFieldErrors());
		if (!result.hasErrors()) {
			repository.saveAndFlush(Person);
			res = new ModelAndView("redirect:/schedulelist");
		} else {
			mav.setViewName("edit");
			Iterable<Person> list = repository.findAll();
			mav.addObject("datalist", list);
			res = mav;
		}
		return res;
	}

	//IDを取得
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView mav,  Principal principal,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		mav.setViewName("delete");
		Optional<Person> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/schedulelist");
	}

	//IDを取得
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@ModelAttribute Person Person, Principal principal,
			@PathVariable int id, ModelAndView mav,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		mav.setViewName("detail");
		Optional<Person> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@Transactional
	public ModelAndView detail(@ModelAttribute Person Person,
			ModelAndView mav) {
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/schedulelist");
	}

}