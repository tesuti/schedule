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

import jakarta.annotation.PostConstruct;
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

	@RequestMapping("/create")
	public ModelAndView create(
			@ModelAttribute("formModel") Person Person,

			ModelAndView mav,Principal principal,Model model) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);

			ModelAndView mav) {
		mav.setViewName("create");

		List<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	//予定を登録
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional
	public ModelAndView form(
			@ModelAttribute("formModel") @Validated Person Person,
			BindingResult result,
			ModelAndView mav) {
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

	public ModelAndView edit(@ModelAttribute("formModel") Person Person,
			@PathVariable int id, ModelAndView mav) {

		mav.setViewName("edit");
		Optional<Person> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	//取得されたIDのデータを変更
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional
	public ModelAndView update(
			@ModelAttribute("formModel") @Validated Person Person,
			BindingResult result,
			ModelAndView mav) {
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

	//取得されたIDのデータを削除
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

	//アプリケーション起動時、ダミーデータ作成
	@PostConstruct
	public void init() {
		// １つ目のダミーデータ作成
		Person p1 = new Person();
		p1.setId(1);
		p1.setTitle("ランニング");
		p1.setBody("公園を3周する");
		p1.setBackgroundColor("red");
		p1.setStart("2023-11-21T13:29");
		p1.setEnd("2023-11-21T15:29");
		repository.saveAndFlush(p1);
		// ２つ目のダミーデータ作成
		Person p2 = new Person();
		p2.setId(2);
		p2.setTitle("旅行");
		p2.setBody("京都巡り");
		p2.setBackgroundColor("blue");
		p2.setStart("2023-11-12T13:29");
		p2.setEnd("2023-11-18T13:29");
		repository.saveAndFlush(p2);

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@Transactional
	public ModelAndView detail(@ModelAttribute Person Person,
			ModelAndView mav) {
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/schedulelist");
	}
	  @PostConstruct
	  public void init1(){
	    // １つ目のダミーデータ作成
	    Person p1 = new Person();
	    p1.setId(1);
	    p1.setTitle("ランニング");
	    p1.setBody("公園を3周する");
	    p1.setBackgroundColor("#ff0000");
	    p1.setStart("2023-12-21T13:29");
	    p1.setEnd("2023-12-21T15:29");
	    repository.saveAndFlush(p1);
	    // ２つ目のダミーデータ作成
	    Person p2 = new Person();
	    p2.setId(2);
	    p2.setTitle("旅行");
	    p2.setBody("京都巡り");
	    p2.setBackgroundColor("#f6b73c");
	    p2.setStart("2023-12-12T13:29");
	    p2.setEnd("2023-12-18T13:29");
	    repository.saveAndFlush(p2);
	    
	    Person p3 = new Person();
	    p3.setId(3);
	    p3.setTitle("旅行");
	    p3.setBody("京都巡り");
	    p3.setBackgroundColor("#e66465");
	    p3.setStart("2023-12-21T13:29");
	    p3.setEnd("2023-12-18T13:29");
	    repository.saveAndFlush(p3);



	}

}