package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))") // pointcut
																															// 설정
	public void beforeAdvice() { // 핵심관심 앞(find 앞)
		System.out.println("---Before Advice---");
	}

	@After("execution(* *..*.service.ProductService.*(..))") // pointcut 설정
	// 반환타입 => * , com.douzone.aoptest => *..* 두개 이상 줄일때 *..*
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}

	@AfterReturning("execution(* *..*.ProductService.*(..))") // pointcut 설정
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}

	@AfterThrowing(value = "execution(* *..*.*.*(..))", throwing = "ex") // 모든 클래스 => GlobalException
	public void afterThrowing(Throwable ex) {
		System.out.println("---After AfterThrowing Advice: " + ex + "---");
	}

	@Around("execution(* *..*.ProductService.*(..))") // pointcut 설정
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// Before Advice
		System.out.println("@Around(Before) Advice");
	
		// PointCut Method 실행
		
		// 파라미터 가로채기(바꿔버리기)
		//Object[] params = {"Camera"};
		//Object result = pjp.proceed(params);
		
		Object result = pjp.proceed();
		
		// After Advice
		System.out.println("@Around(After) Advice");

		return result;
	
	}

}
