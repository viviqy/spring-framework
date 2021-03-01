package com.fairychar.core.learning;

import com.fairychar.core.learning.beans.FirstDog;
import com.fairychar.core.learning.beans.SecondDog;
import com.fairychar.core.learning.configuration.AppConfiguration;
import com.fairychar.core.learning.service.CustomerService;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static com.fairychar.core.learning.utils.WrapUtil.wrapPrintln;
/**
 * Datetime: 2020/12/17 17:46 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class App {

	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext();
		configAllowCircular(true);
		context.register(AppConfiguration.class);
		context.refresh();

		changeBeanFromBeanFactoryPostProcessor();
		cycleBean();

	}

	/**
	 * 配置是否允许循环依赖
	 * @param isAllow 默认为true
	 */
	private static void configAllowCircular(boolean isAllow) {
		AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) context.getBeanFactory();
		beanFactory.setAllowCircularReferences(isAllow);
	}

	private static void cycleBean() {
		CustomerService customerService = context.getBean(CustomerService.class);
		wrapPrintln(customerService.toString());
	}


	private final static void changeBeanFromBeanFactoryPostProcessor() {
		SecondDog fromSecondDogClass = context.getBean(SecondDog.class);
		fromSecondDogClass.wangwang();
		Object dog = context.getBean("firstDog");
		System.out.println(dog);
		// 预期报错类型转换异常
		try {
			FirstDog firstDog = (FirstDog) context.getBean("firstDog");
			firstDog.wangwang();
		} catch (Exception e) {
			//ignore
		}
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