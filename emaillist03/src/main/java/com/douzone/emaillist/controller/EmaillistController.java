package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
//  public String index(Model model) {
//	List<EmaillistVo> list = new EmaillistRepository().findAll();
//	model.addAttribute("list", list);
//=>
	@Autowired	// DI, EmaillistRepository를 부모까지 찾아보고 자동으로 객체 묶어줘
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}
//<=	
	
	@RequestMapping("/form")
	public String form() {
		return "WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";	// => redirect:/emaillist03/
	}
}
