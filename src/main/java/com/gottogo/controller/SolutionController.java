package com.gottogo.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Solution;
import com.gottogo.model.Language;
import com.gottogo.repository.LanguageRepository;
import com.gottogo.repository.SolutionRepository;

@Controller
public class SolutionController {
	
	@Autowired
	public LanguageRepository repLang;
	@Autowired
	public SolutionRepository rep;
	
	@RequestMapping(value="/ItemLanguages/{id}/items", method=RequestMethod.POST)
	public String edit(Solution solu, @PathVariable("id") long id){
		Language lang = repLang.findById(id);
		solu.setLanguage(lang);
		rep.save(solu);
		return "redirect:/ItemLanguages/{id}/items";
	}
	
	@RequestMapping(value="/ItemLanguages/{id}/items", method=RequestMethod.GET)
	public ModelAndView listViewLanguages(@PathVariable("id") long id){
	
		Language lang = repLang.findById(id);
		ModelAndView mv = new ModelAndView("views/ItemView");
		mv.addObject("lang", lang);
		
		Iterable<Solution> solution = rep.findByLanguage(lang);
		mv.addObject("solution", solution);
		return mv;
	}
	
	
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
//	

//	
//	@RequestMapping(value="/ItemLanguages/{id}/items", method=RequestMethod.GET)
//	public ModelAndView form(){
//		ModelAndView mv = new ModelAndView("ItemView");
//		Solution solu = new Solution();
//		return mv;
//	}
//	@RequestMapping("/ItemLanguages/{id}/items")
//	public ModelAndView listViewSolution(@PathVariable("id") long id){
//		ModelAndView mv = new ModelAndView("/ItemLanguages/{id}/items");
//		Iterable<Solution> solu = rep.findAll();
//		mv.addObject("solution", solu);
//		return mv;
//	}

}
