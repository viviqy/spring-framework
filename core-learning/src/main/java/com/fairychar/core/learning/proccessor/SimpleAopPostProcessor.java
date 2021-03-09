package com.fairychar.core.learning.proccessor;

import com.fairychar.core.learning.service.FoolishAopService;
import com.fairychar.core.learning.utils.SimpleCglibUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Datetime: 2021/3/9 11:00 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class SimpleAopPostProcessor implements BeanPostProcessor {
	@Override
	@SuppressWarnings("unchecked")
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof FoolishAopService) {
			bean = SimpleCglibUtil.proxy(bean.getClass());
		}
		return bean;
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