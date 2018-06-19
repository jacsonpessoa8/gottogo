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
	
	@RequestMapping(value="/items/solucao/{id}", method=RequestMethod.POST)
	public String novoSolu(Solution solu, @PathVariable("id") long id){
		Language lang = repLang.findById(id);
		solu.setLanguage(lang);
		rep.save(solu);
		return "redirect:/items/{id}";
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
		return "redirect:/items/"+id;
	}
	
	@RequestMapping(value="/items/{id}/delete", method=RequestMethod.GET)
	public String deletar(@PathVariable("id") long id){
		Solution solu = rep.findById(id);
		id = solu.getLanguage().getId();
		rep.deleteById(solu.getId());
		return "redirect:/items/"+id;
	}
	
	@RequestMapping(value="/items/{id}/busca", method=RequestMethod.POST)
	public ModelAndView busca(@PathVariable("id") long id, @RequestParam("buscaName") String title){
		Language lang = repLang.findById(id);
		ModelAndView mv = new ModelAndView("views/ItemView");
		mv.addObject("lang", lang);
		
		Iterable<Solution> solution = rep.findByLanguageAndTitle(lang, title);
		mv.addObject("solution", solution);
		return mv;
	}
}
