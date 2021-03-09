package com.fairychar.core.learning.service.aop;

import org.springframework.stereotype.Service;

/**
 * Datetime: 2021/3/9 15:11 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Service
public class ComplexAopService {

	public void show(){
		System.out.println("complex aop service...");
	}

	public String show(String source){
		System.out.println("complex aop service args="+source);
		return "complex: "+source;
	}

	public String show(String source,String concat){
		return source+":"+concat;
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