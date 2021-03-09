import com.fairychar.core.learning.configuration.FoolishAopConfiguration;
import com.fairychar.core.learning.service.FoolishAopService;
import com.fairychar.core.learning.utils.WrapUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Datetime: 2021/3/9 11:40 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class FoolishAopSample {

	private  static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		WrapUtil.wrapPrintln("foolish aop sample");
		context=new AnnotationConfigApplicationContext();
		context.register(FoolishAopConfiguration.class);
		context.refresh();

		FoolishAopService foolishAopService = context.getBean(FoolishAopService.class);
//		System.out.println(simpleAopService);
		foolishAopService.show();
		foolishAopService.show("heihei");
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