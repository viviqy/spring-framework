package com.fairychar.core.learning.service;

import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Datetime: 2020/12/22 15:25 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Service
public class CustomerService implements InitializingBean {

	@Autowired
	private OrderService orderService;

	public CustomerService(OrderService orderService) {
		WrapUtil.wrapPrintln("into customer 1param constructor");
		this.orderService = orderService;
	}

	public CustomerService() {
	}

	/**
	 * Invoked by the containing {@code BeanFactory} after it has set all bean properties
	 * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
	 * <p>This method allows the bean instance to perform validation of its overall
	 * configuration and final initialization when all bean properties have been set.
	 *
	 * @throws Exception in the event of misconfiguration (such as failure to set an
	 *                   essential property) or if initialization fails for any other reason
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		WrapUtil.wrapPrintln("into customerService afterProperties...");
	}

	@Override
	public String toString() {
		return "CustomerService{ this=" +this.hashCode()+
				"  orderService=" + orderService.hashCode() +
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