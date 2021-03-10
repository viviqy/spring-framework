import com.fairychar.core.learning.configuration.ComplexAopConfiguration;
import com.fairychar.core.learning.configuration.FoolishAopConfiguration;
import com.fairychar.core.learning.service.aop.ComplexAopService;
import com.fairychar.core.learning.service.aop.IJdkProxyService;
import com.fairychar.core.learning.service.aop.JdkProxyService;
import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Datetime: 2021/3/9 15:41 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class ComplexAopSample {
	private  static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		WrapUtil.wrapPrintln("complex aop sample");
		context=new AnnotationConfigApplicationContext();
		context.register(ComplexAopConfiguration.class);
		context.refresh();
		ComplexAopService service = context.getBean(ComplexAopService.class);
		service.show("xiaoqi");
		service.show();
		service.show("donggou","fengzi");


		//jdk 代理,因为不是通过cglib所以无法找到该bean
//		JdkProxyService jdkProxyService = context.getBean(JdkProxyService.class);
//		jdkProxyService.jdkShow();

		IJdkProxyService iJdkProxyService = context.getBean(IJdkProxyService.class);
		iJdkProxyService.jdkShow();
		context.close();
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