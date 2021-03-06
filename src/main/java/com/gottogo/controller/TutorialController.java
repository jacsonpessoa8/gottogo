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
import com.gottogo.repository.SolutionRepository;

@Controller
public class TutorialController {
	
	@Autowired
	private SolutionRepository repSol;
	
	@RequestMapping("/tutorial/{id}")
	public ModelAndView listViewLanguages(@PathVariable("id") long id){
		ModelAndView mv = new ModelAndView("views/tutorial");
		Solution solution = repSol.findById(id);
		mv.addObject("solution", solution);
		return mv;
	}
	@RequestMapping(value="/tutorial/{id}",  method=RequestMethod.POST)
	public String salvarAlteracao(@PathVariable("id") long id, @RequestParam("title") String name, @RequestParam("description") String description){
		Solution sol = repSol.findById(id);
		sol.setTitle(name);
		sol.setDescription(description);
		repSol.save(sol);
		return "redirect:/tutorial/" + id;
	}
}
