import com.fairychar.core.learning.beans.GenJi;
import com.fairychar.core.learning.beans.HanZo;
import com.fairychar.core.learning.configuration.CglibSampleConfiguration;
import com.fairychar.core.learning.configuration.CircularReferenceConfiguration;
import com.fairychar.core.learning.utils.WrapUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Datetime: 2020/12/24 12:48 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class TestMain {
	private static final Object LOCK = new Object();
	private  static AnnotationConfigApplicationContext context;


	@Test
	public void testCircularReference(){

	}

	@Test
	public void testCglibConfigurationSample(){
		context = new AnnotationConfigApplicationContext();
		context.register(CglibSampleConfiguration.class);
		context.refresh();
		System.out.println(context.getBean(GenJi.class));
		System.out.println(context.getBean(HanZo.class));
		context.close();
	}

	@Test
	public void testWrap() {
		WrapUtil.wrapPrintln("hahah");
	}

	@Test
	public void testLock() throws InterruptedException {
		int N = 10;
		Thread[] threads = new Thread[10];
		for (int i = 0; i < N; i++) {
			threads[i] = new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " begin...");
				synchronized (LOCK) {
					System.out.println(Thread.currentThread().getName() + "get sync lock!");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "thread [" + i + "]");
		}
		synchronized (LOCK) {
			for (int i = 0; i < N; i++) {
				threads[i].start();
				System.out.println(threads[i].getName() + " start!");
				Thread.sleep(200);
			}
			Thread.sleep(200);
		}
		Thread.currentThread().join();
	}

}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   2
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