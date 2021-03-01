package proxy;

import org.junit.Test;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IDEA <br>
 * Date: 2021/02/24 <br>
 * time: 21:54 <br>
 *
 * @author chiyo <br>
 */

public class ProxySample {

	@Test
	public void test() {
		UserDao mapper = UserFactory.getMapper(UserDao.class);
		System.out.println(mapper.findAll());
	}


	public interface UserDao {
		@Scope("select * from user")
		String findAll();

	}

	public static class UserFactory {
		static <T> T getMapper(Class<T> clazz) {
			Object o = Proxy.newProxyInstance(UserFactory.class.getClassLoader(), new Class[]{clazz}, new UserInvocationHandler());
			return (T) o;
		}
	}

	public static class UserInvocationHandler implements InvocationHandler {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("get sql session");
			Scope scope = method.getAnnotation(Scope.class);
			System.out.println("select from db sql=" + scope.value());
			return "all users";
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