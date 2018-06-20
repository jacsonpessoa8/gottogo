package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.model.User;
import com.gottogo.repository.LanguageRepository;
import com.gottogo.repository.SolutionRepository;
import com.gottogo.repository.UserRepository;

@Controller
public class DashboardController {
	
	@Autowired
	public LanguageRepository repLang;
	
	@Autowired
	public SolutionRepository repSolu;
	
	@Autowired
	public UserRepository repUser;
	
	
	@RequestMapping("/DashListUser")
	public ModelAndView DashUser(){
		ModelAndView mv = new ModelAndView("views/Dashboard/UserDash");
		Iterable<User> user = repUser.findAll();
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/Dashboard")
	public ModelAndView DashPermition(){
		ModelAndView mv = new ModelAndView("views/Dashboard/dashboard");
		Iterable<Language> permition = repLang.findAll();
		Long quantLang = repLang.countLang();
		mv.addObject("lang", permition);
		mv.addObject("quantLang", quantLang);
		return mv;
	}
	
}
