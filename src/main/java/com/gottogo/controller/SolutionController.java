package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Solution;
import com.gottogo.repository.LanguageRepository;
import com.gottogo.repository.SolutionRepository;

@Controller
public class SolutionController {
	
	@Autowired
	public LanguageRepository repLang;
	@Autowired
	public SolutionRepository rep;
	
//	@RequestMapping(value="items/{id}", method=RequestMethod.GET)
//	public ModelAndView listViewLanguages(@PathVariable("id") long id){
//	
//		Language lang = repLang.findById(id);
//		ModelAndView mv = new ModelAndView("views/ItemView");
//		mv.addObject("lang", lang);
//		
//		Iterable<Solution> solution = rep.findByLanguage(lang);
//		mv.addObject("solution", solution);
//		return mv;
//	}
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public String form(){
		
		return "views/ItemView";
	}
	@RequestMapping("/items")
	public ModelAndView listViewLanguages(){
		ModelAndView mv = new ModelAndView("views/ItemView");
		Iterable<Solution> solu = rep.findAll();
		mv.addObject("solution", solu);
		return mv;
	}
}
