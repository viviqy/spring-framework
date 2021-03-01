package com.fairychar.core.learning;

import com.fairychar.core.learning.beans.FirstDog;
import com.fairychar.core.learning.beans.SecondDog;
import com.fairychar.core.learning.beans.definition.SchoolPeopleDefinition;
import com.fairychar.core.learning.beans.definition.StudentDefinition;
import com.fairychar.core.learning.configuration.AppConfiguration;
import com.fairychar.core.learning.service.CustomerService;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
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

		configBeanDefinition();


		context.refresh();
		showBeanDefinition();
		changeBeanFromBeanFactoryPostProcessor();
		circularDependencyBean();
	}

	private static void showBeanDefinition() {
		StudentDefinition so = context.getBean("so",StudentDefinition.class);
		StudentDefinition fr = context.getBean("fr",StudentDefinition.class);
		wrapPrintln(so.toString());
		wrapPrintln(fr.toString());
	}

	private static void configBeanDefinition() {
		//可作为父BeanDefinition出现,真是BeanDefinition出现,不能作为子BeanDefinition
		RootBeanDefinition root = new RootBeanDefinition();
		root.setBeanClass(SchoolPeopleDefinition.class);
		//设置setAbstract就可以不设置class,且不会实例化bean到spring容器,所以不能被getBean获取出来
//		root.setAbstract(true);
		root.getPropertyValues().add("name","xiaoqi");
		context.registerBeanDefinition("sp",root);
		//继承关系,以前的写法现在基本无用
		ChildBeanDefinition fromRoot= new ChildBeanDefinition("sp");
		fromRoot.setBeanClass(StudentDefinition.class);
		fromRoot.getPropertyValues().add("age",11);
		context.registerBeanDefinition("fr",fromRoot);

		ChildBeanDefinition child = new ChildBeanDefinition("sp");
		child.setBeanClass(StudentDefinition.class);
		child.getPropertyValues().add("age",10)
				.add("name","override");
		context.registerBeanDefinition("so",child);


		//spring 2.5之后使用这个
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

	}

	/**
	 * 配置是否允许循环依赖
	 *
	 * @param isAllow 默认为true
	 */
	private static void configAllowCircular(boolean isAllow) {
		AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) context.getBeanFactory();
		beanFactory.setAllowCircularReferences(isAllow);
	}

	/**
	 * 循环依赖
	 */
	private static void circularDependencyBean() {
		CustomerService customerService = context.getBean(CustomerService.class);
		wrapPrintln(customerService.toString());
	}


	/**
	 * 调用后置处理器替换FirstDog为SecondDog
	 */
	private final static void changeBeanFromBeanFactoryPostProcessor() {
		SecondDog fromSecondDogClass = context.getBean(SecondDog.class);
		fromSecondDogClass.wangwang();
		Object dog = context.getBean("firstDog");
		System.out.println(dog);
		// 预期报错类型转换异常
		try {
			FirstDog firstDog = (FirstDog) context.getBean("firstDog");
			firstDog.wangwang();
		} catch (ClassCastException e) {
			System.err.println("预期捕获到的类型转换异常");
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