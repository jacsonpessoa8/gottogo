package com.gottogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "redirect:/ItemLanguages";
	}
	@RequestMapping("/login")
	public String login(){
		return "views/login";
	}
}
