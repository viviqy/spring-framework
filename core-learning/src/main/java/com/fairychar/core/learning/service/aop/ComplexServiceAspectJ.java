package com.fairychar.core.learning.service.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Datetime: 2021/3/9 15:36 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Aspect
@Component
public class ComplexServiceAspectJ {


	/**
	 * 切所有参数的方法
	 */
	@Pointcut("execution(public * com.fairychar.core.learning.service.aop.*.*(..))")
	public void simpleShow() {

	}

//	/**
//	 * within最大力度只能指定到类,而execution可以指定到方法的返回值,参数个数,方法名等
//	 */
//	@Pointcut("within(com.fairychar.core.learning.service.aop.ComplexAopService)")
//	public void simpleShowWithin() {
//
//	}


	@Pointcut("args(java.lang.String)")
	public void argsShow() {
	}


	@Before("argsShow()")
	public void argsBefore() {
		System.out.println("xxxxx");
	}

	@Before("simpleShow() &&! argsShow()")
	public void complexBefore() {
		System.out.println("yyyyy");
	}


	/**
	 * 必须代理当前IJdkProxyService,并通过getBean获取IJdkProxyService才能取出代理对象
	 * 并实现aop的代理,如果是代理JdkProxyService,则无法代理到接口方法,起不到代理作用
	 */
	@Before("this(com.fairychar.core.learning.service.aop.IJdkProxyService)")
	public void jdkBefore() {
		System.out.println("zzzzz");
	}
//	@Before("execution(public * com.fairychar.core.learning.service.aop.*.*(..)) && args(java.lang.String)")
//	public void complexBefore(){
//		System.out.println("yyyyy");
//	}
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/