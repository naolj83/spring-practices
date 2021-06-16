package com.douzone.hellospring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HelloSpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {	// getRootConfigClasses()는 리스너가 하는거(AppConfig 달라)
		// Root Applicaiton Context 설정 클래스
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Applicaiton Context 설정 클래스
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// DispatcherServlet Mapping URL
		return new String[] {"/"};
	}

}
