import com.fairychar.core.learning.configuration.CircularReferenceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Datetime: 2021/3/5 16:03 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class CirularReferenceSample {
	private  static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.register(CircularReferenceConfiguration.class);
		context.refresh();
		System.out.println(context.getBean("customerService"));
		System.out.println(context.getBean("orderService"));
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