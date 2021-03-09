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