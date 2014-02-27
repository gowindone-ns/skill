package edu.learning.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/h")
public class HelloController {

	@RequestMapping(method = RequestMethod.POST)
	public String printHello(ModelMap model, @RequestParam String username,
			@RequestParam String password) {
		model.addAttribute("msg", "Hello Spring MVC Framework!");

		return "hello";
	}

}