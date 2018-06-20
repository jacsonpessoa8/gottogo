package com.gottogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.model.Permition;
import com.gottogo.model.Solution;
import com.gottogo.model.UserSys;
import com.gottogo.repository.LanguageRepository;
import com.gottogo.repository.PermitionRepository;
import com.gottogo.repository.SolutionRepository;
import com.gottogo.repository.UserSysRepository;

@Controller
public class SystemController {
	
	@Autowired
	private UserSysRepository repUser;
	@Autowired
	private SolutionRepository repSol;
	@Autowired
	private LanguageRepository repLang;	
	@Autowired
	private PermitionRepository repRepo;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(){
		
		return "views/register";
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String form(UserSys userSys){
		String oldPassw = userSys.getPassword();
		userSys.setPassword(new BCryptPasswordEncoder().encode(oldPassw));
		Permition permDefault = repRepo.findByName("ROLE_USER");
		List<Permition> listPerm = new ArrayList();
		listPerm.add(permDefault);
		userSys.setPermitions(listPerm);
		repUser.save(userSys);
		return "redirect:/form";
	}
	@RequestMapping("/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView("views/domain-admin/show");
		Iterable<UserSys> userSys = repUser.findAll();
		mv.addObject("user", userSys);
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
