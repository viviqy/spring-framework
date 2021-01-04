package com.fairychar.core.learning.configuration;

import com.fairychar.core.learning.beans.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Datetime: 2021/1/4 11:08 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
//@Configuration
public class OrderedBeanConfiguration {
	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE-3)
	Apple apple1(){
		System.out.println("apple 1");
		return new Apple();
	}

	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE-2)
	Apple apple2(){
		System.out.println("apple 2");
		return new Apple();
	}

	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE-1)
	Apple apple3(){
		System.out.println("apple 3");
		return new Apple();
	}


	@Bean
	@Order(Ordered.LOWEST_PRECEDENCE-6)
	Apple apple4(){
		System.out.println("apple 4");
		return new Apple();
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