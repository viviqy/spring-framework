package com.fairychar.core.learning.utils;

import com.fairychar.core.learning.interceptor.CglibMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Datetime: 2021/3/9 11:18 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class SimpleCglibUtil {

	@SuppressWarnings("unchecked")
	public static <T> T proxy(Class<T> beanClass) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(beanClass);
		enhancer.setCallback(new CglibMethodInterceptor());
		return (T) enhancer.create();
	}
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