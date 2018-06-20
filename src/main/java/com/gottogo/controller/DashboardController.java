package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.model.Solution;
import com.gottogo.repository.LanguageRepository;

@Controller
public class LanguageController {
	
	@Autowired
	public LanguageRepository repLang;
	
	@RequestMapping("/DashListUser")
	public ModelAndView DashUser(){
		ModelAndView mv = new ModelAndView("views/Dashboard/UserDash");
		Iterable<Language> user = rep.findAll();
		mv.addObject("lang", user);
		return mv;
	}
	
	@RequestMapping(value="/DashListPermitions")
	public ModelAndView DashPermition(){
		ModelAndView mv = new ModelAndView("views/Dashboard/PermissionDash");
		Iterable<Language> permition = rep.findAll();
		mv.addObject("lang", permition);
		return mv;
	}
	
	@RequestMapping("/ItemLanguages")
	public ModelAndView listViewLanguages(){
		ModelAndView mv = new ModelAndView("views/ListViewLanguages");
		Iterable<Language> lang = rep.findAll();
		mv.addObject("lang", lang);
		return mv;
	}
	
	@RequestMapping("/ItemLanguages")
	public ModelAndView listViewSolutions(){
		ModelAndView mv = new ModelAndView("views/ItemView");
		Iterable<Solution> solution = rep.findAll();
		mv.addObject("lang", solution);
		return mv;
	}
	
}
