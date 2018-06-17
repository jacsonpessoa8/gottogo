package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.repository.LanguageRepository;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageRepository rep;
	
	@RequestMapping(value="/formLang", method=RequestMethod.GET)
	public String form(){
		
		return "views/domain-admin/formLang";
	}
	@RequestMapping(value="/formLang", method=RequestMethod.POST)
	public String form(Language lang){
		rep.save(lang);
		return "redirect:/formLang";
	}
	
	@RequestMapping("/ItemLanguages")
	public ModelAndView listViewLanguages(){
		ModelAndView mv = new ModelAndView("views/ListViewLanguages");
		Iterable<Language> lang = rep.findAll();
		mv.addObject("lang", lang);
		return mv;
	}
	
	@RequestMapping(value="/ItemLanguages", method=RequestMethod.POST)
	public String form2(Language lang){
		rep.save(lang);
		return "redirect:/ItemLanguages";
	}
	
	@RequestMapping(value="/ItemLanguages/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") long id){
		Language lang = rep.findById(id);
		ModelAndView mv = new ModelAndView("views/domain-admin/formLang");
		mv.addObject("findById", lang);
		return mv;
	}
	
	@RequestMapping(value="/ItemLanguages/{id}",  method=RequestMethod.POST)
	public String edit2(@PathVariable("id") long id, @RequestParam("name") String name){
		Language lang = rep.findById(id);
		lang.setName(name);
		rep.save(lang);
		return "redirect:/ItemLanguages";
	}
	
}
