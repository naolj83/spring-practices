package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {
	public static void main(String[] args) {
// 컨테이너 생성 
// ApplicationContext  - containeer, ("config/applicationContext.xml") - xml 위치
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("Tv");
		System.out.println("[main]" + vo);
	
		((AbstractApplicationContext)ac).close();
	}

}
