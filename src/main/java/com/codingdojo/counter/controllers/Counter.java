package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
	int num = 0;
	
	session.setAttribute("count", num);
	
	model.addAttribute("count", session.getAttribute("count"));
	
	return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
	session.getAttribute("count");
	
	int num = (int)session.getAttribute("count");
	num++;
	
	session.setAttribute("count", num);
	model.addAttribute("count", session.getAttribute("count"));
	
	return "counter.jsp";
	}
	
	@RequestMapping("/countertwo")
	public String counter2(HttpSession session, Model model) {
	session.getAttribute("count");
	
	int num = (int)session.getAttribute("count");
	num = num + 2;
	
	session.setAttribute("count", num);
	model.addAttribute("count", session.getAttribute("count"));
	
	return "countBy2.jsp";
	}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
}






