package edu.learning.spring.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.learning.spring.model.UserProfileId;

@Controller
@RequestMapping("/in")
@Transactional(readOnly = true) 
public class LoginController {
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello() {	
		return "login";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String printHello(ModelMap model, @RequestParam String username,
			@RequestParam String password) {
		System.out.println(((UserProfileId)sessionFactory.getCurrentSession().get(UserProfileId.class, "1001")).getPassword());
		model.addAttribute("msg", "Hello Spring MVC Framework!");

		return "login";
	}

}