package com.gottogo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gottogo.model.Language;
import com.gottogo.model.Permition;
import com.gottogo.repository.LanguageRepository;

@Controller
public class LanguageController {

	@Autowired
	private LanguageRepository rep;

	@RequestMapping(value = "/formLang", method = RequestMethod.POST)
	public String form(Language lang) {
		rep.save(lang);
		return "redirect:/formLang";
	}

	@RequestMapping("/ItemLanguages")
	public ModelAndView listViewLanguages() {
		ModelAndView mv = new ModelAndView("views/ListViewLanguages");
		Iterable<Language> lang = rep.findAll();
		mv.addObject("lang", lang);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		Collection<? extends GrantedAuthority> perm = auth.getAuthorities();
		mv.addObject("username", name);
		mv.addObject("auth", perm.toArray()[0]);
		return mv;
	}

	@RequestMapping(value = "/ItemLanguages", method = RequestMethod.POST)
	public String form2(Language lang) {
		rep.save(lang);
		return "redirect:/ItemLanguages";
	}

	@RequestMapping(value = "/ItemLanguages/{id}/delete", method = RequestMethod.GET)
	public String deletar(@PathVariable("id") long id) {
		Language lang = rep.findById(id);
		rep.deleteById(lang.getId());
		return "redirect:/ItemLanguages";
	}

}
