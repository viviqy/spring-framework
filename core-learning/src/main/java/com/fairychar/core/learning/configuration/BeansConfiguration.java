package com.fairychar.core.learning.configuration;

import com.fairychar.core.learning.beans.Apple;
import com.fairychar.core.learning.beans.DaShen;
import com.fairychar.core.learning.beans.XiaoQi;
import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.AliasFor;

/**
 * Datetime: 2020/12/18 13:27 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Configuration
public class BeansConfiguration {
	@Bean(initMethod = "init",destroyMethod = "eat")
	Apple apple() {
		WrapUtil.wrapPrintln("apple beansConfiguraion");
		Apple apple = new Apple();
		apple.setColor("red");
		return apple;
	}


	@Bean
	@DependsOn("daShen")
	XiaoQi xiaoQi(){
		return new XiaoQi();
	}

	@Bean
	DaShen daShen(){
		return new DaShen();
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