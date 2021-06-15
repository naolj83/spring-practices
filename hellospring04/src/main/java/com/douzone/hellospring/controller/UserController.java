package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//	@RequestMapping(value="/join", method=RequestMethod.POST)	
//	public String join(ModelAttribute UserVo vo) {	//Model이 나오면 jsp
//		System.out.println(vo);
//		return "redirect:/";
//	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {	//@RequestParam(vlue="n", required=true)
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우(required=true)
		 * 400 Bad Request 에러가 발생한다.
		 */
		System.out.println(name);
		return "UserController.update()";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) String name) {
		System.out.println(name);
		if(name == null) {
			name = "";
		}
		return "UserController.update2()";
	}
	
	@ResponseBody
	@RequestMapping("/update22")
	public String update22(
			@RequestParam(value="n", required=true, defaultValue = "1") String name,
			@RequestParam(value="a", required=true, defaultValue = "0") String age) {
		System.out.println("---" + name + "---" + age);
		return "UserController.update22()";
	}
	
}