package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/vvv")
public class UserController {

	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/aaa/hello.jsp";
	}
	
	@RequestMapping("/main")
	public String main2222() {
		return "/WEB-INF/aaa/hello2.jsp";
	}

	@RequestMapping("/hello2")
	public String hello222(String n) {
		System.out.println(n);
		return "/WEB-INF/aaa/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello33(String namee, String na) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("n", namee);
		mav.addObject("b", na);
		mav.setViewName("/WEB-INF/aaa/hello2.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String n, Model mo) {
		mo.addAttribute("c", n);
		return "/WEB-INF/aaa/hello2.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/board/aaaa")
	public String aaa() {
		return "gg";
	}
	
	@ResponseBody
	@RequestMapping("/qwe/ddd/{a}")
	public String viewsss(@PathVariable("a") Long no) {
		return "qwe (" + no + ")";
	}
	

	@RequestMapping(value="/ee", method=RequestMethod.GET)
	public String eee() {
		return "/WEB-INF/aaa/join.jsp";
	}
	
//	@RequestMapping(value = "/join")
//	public String temp() {
//		return "/WEB-INF/aaa/join.jsp";
//	}
	
	@ResponseBody
	@RequestMapping({"/", "/abc"})
	public String mainn() {
		return "ddd";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String eee(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
}
