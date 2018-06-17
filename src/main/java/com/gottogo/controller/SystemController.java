package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.model.Solution;
import com.gottogo.model.User;
import com.gottogo.repository.LanguageRepository;
import com.gottogo.repository.SolutionRepository;
import com.gottogo.repository.UserRepository;

@Controller
public class SystemController {
	
	@Autowired
	private UserRepository repUser;
	@Autowired
	private SolutionRepository repSol;
	@Autowired
	private LanguageRepository repLang;	
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		
		return "views/register";
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String form(User user){
		repUser.save(user);
		return "redirect:/form";
	}
	@RequestMapping("/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView("views/domain-admin/show");
		Iterable<User> user = repUser.findAll();
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/formSolution", method=RequestMethod.GET)
	public String formLang(){
		
		return "views/domain-admin/formSolu";
	}
	@RequestMapping(value="/formSolution", method=RequestMethod.POST)
	public String formLang(Language lang){
		repLang.save(lang);
		return "redirect:/formSolution";
	}
	@RequestMapping("/showSolution")
	public ModelAndView showLang() {
		ModelAndView mv = new ModelAndView("views/domain-admin/showSolution");
		Iterable<Solution> sol = repSol.findAll();
		mv.addObject("solution", sol);
		return mv;
	}
}
