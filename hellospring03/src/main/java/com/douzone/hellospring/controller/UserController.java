package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 클래스 + 핸들러(메소드)
 * @author bit-user
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)	//post방식(파라미터 필요)-데이터처리
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
}