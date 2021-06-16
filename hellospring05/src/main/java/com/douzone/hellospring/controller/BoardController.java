package com.douzone.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 메소드 단독 매핑
 * 
 * @author bit-user
 * 
 */
@Controller
public class BoardController {
		
		@ResponseBody	//브라우저로 바로 보냄
		@RequestMapping("/board/write")
		public String write() {
			return "BoardController:write";
		}
		
		@ResponseBody
		@RequestMapping("/board/views/{n}")
		public String view(@PathVariable("n") Long boardNo) {
			return "BoardController:view(" + boardNo + ")";
		}

	
}
