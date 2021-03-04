package proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

/**
 * Datetime: 2021/3/3 22:01 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class CglibEnhancerProxySample {
	private  static AnnotationConfigApplicationContext context;

	@Test
	public void testEnhancer() throws Exception{
//		context = new AnnotationConfigApplicationContext();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(NotVeryUsefulCglibService.class);
		enhancer.setCallback(new CglibMethodInterceptor());
		NotVeryUsefulCglibService cglibService = (NotVeryUsefulCglibService) enhancer.create();
		System.out.println(cglibService.hello());
		System.out.println(cglibService);
//		context.refresh();
//		context.close();
	}


	public static class NotVeryUsefulCglibService{
		public String hello(){
			System.out.println("in hello");
			return "hello";
		}
	}

	public static class CglibMethodInterceptor implements MethodInterceptor{
		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			System.out.println("in cglib method interceptor...");
			return methodProxy.invokeSuper(o,method.getParameters());
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