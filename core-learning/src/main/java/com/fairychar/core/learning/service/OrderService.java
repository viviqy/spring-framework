package com.fairychar.core.learning.service;

import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * Datetime: 2020/12/22 15:25 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Service
public class OrderService implements Ordered {

	@Autowired
	private CustomerService customerService;

	public OrderService() {
		System.out.println("in orderService constructor...");
	}


	@Override
	public int getOrder() {
		return 1;
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