package com.fairychar.core.learning.configuration;

import com.fairychar.core.learning.beans.GenJi;
import com.fairychar.core.learning.beans.HanZo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Datetime: 2021/3/3 14:11 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
//加上@Configuration后类变成为被cglib代理的代理类
@Configuration
public class CglibSampleConfiguration {
	@Bean
	HanZo hanZo() {
		genJi();//并不会执行此方法
		return new HanZo();
	}

	@Bean
	GenJi genJi() {
		System.out.println("ryu gen no ken o ku ra e");
		return new GenJi();
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