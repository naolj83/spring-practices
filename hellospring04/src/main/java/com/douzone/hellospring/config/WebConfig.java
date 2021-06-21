package com.douzone.hellospring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//xml설정을 java config로 바꾸는 것
@Configuration			// config 클래스는 다 @configuration 달기
@EnableWebMvc
@ComponentScan({"com.douzone.hellospring.controller"})	
public class WebConfig {
	

}
