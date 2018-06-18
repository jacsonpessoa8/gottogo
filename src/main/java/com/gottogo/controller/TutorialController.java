package com.gottogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
