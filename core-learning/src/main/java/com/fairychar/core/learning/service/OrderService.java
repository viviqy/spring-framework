package com.fairychar.core.learning.service;

import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Datetime: 2020/12/22 15:25 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Service
public class OrderService {

	@Autowired
	private CustomerService customerService;

	public void customerBean() {
		WrapUtil.wrapPrintln(customerService.toString());
	}


	@Override
	public String toString() {
		return "OrderService{ this=" + this.hashCode() +
				"  customerService=" + customerService.hashCode() +
				'}';
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