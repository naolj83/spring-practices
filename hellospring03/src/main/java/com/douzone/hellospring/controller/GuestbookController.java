package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @RequestMapping
 * 클래스(타입) 단독 매핑
 * 
 * @author bit-user
 * 
 */
@Controller
@RequestMapping("/guestbook/*")	//*에는 메서드 이름 매핑
public class GuestbookController {

	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController:delete";
	}
}
