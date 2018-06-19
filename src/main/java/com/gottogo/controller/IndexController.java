package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.repository.LanguageRepository;

@Controller
public class IndexController {
	
	@Autowired
	private LanguageRepository repLang;
	
	@RequestMapping("/")
	public String index(){
		
		return "redirect:/ItemLanguages";
	}
//	@RequestMapping("/ItemLanguages")
//	public ModelAndView listViewLanguages(){
//		ModelAndView mv = new ModelAndView("views/ListViewLanguages");
//		Iterable<Language> lang = repLang.findAll();
//		mv.addObject("lang", lang);
//		return mv;
//	}
//	@RequestMapping(value="/ItemLanguages", method=RequestMethod.GET)
//	public String form(){
//		
//		return "views/ListViewLanguages";
//	}
//	@RequestMapping(value="/ItemLanguages/{id}", method=RequestMethod.GET)
//	public ModelAndView edit(@PathVariable("id") long id){
//		Language lang = repLang.findById(id);
//		ModelAndView mv = new ModelAndView("views/ListViewLanguages");
//		mv.addObject("langById", lang);
//		return mv;
//	}
}
