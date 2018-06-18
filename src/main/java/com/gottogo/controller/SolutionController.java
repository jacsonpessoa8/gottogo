package com.gottogo.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public String ItemView(){
	
		return "view/ItemView";
	}
	
	@RequestMapping(value="items/{id}", method=RequestMethod.GET)
	public ModelAndView ItemViewLanguages(@PathVariable("id") long id){
	
		Language lang = repLang.findById(id);
		ModelAndView mv = new ModelAndView("views/ItemView");
		mv.addObject("lang", lang);
		
		Iterable<Solution> solution = rep.findByLanguage(lang);
		mv.addObject("solution", solution);
		return mv;
	}

	
	@RequestMapping(value="/items/{id}",  method=RequestMethod.POST)
	public String salvarAlteracao(@PathVariable("id") long id, @RequestParam("name") String name){
		Language lang = repLang.findById(id);
		lang.setName(name);
		repLang.save(lang);
		return "redirect:/ItemLanguages";
	}
}
