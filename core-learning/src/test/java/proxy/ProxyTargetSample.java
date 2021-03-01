package proxy;

import org.junit.Test;

/**
 * Datetime: 2021/2/25 11:15 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class ProxyTargetSample {

	@Test
	public void testProxyTarget() {
		ShowName showName = new ShowName();
		ShowAge showAge = new ShowAge(showName);
		ShowGenger showGenger = new ShowGenger(showAge);
		showGenger.show();
	}

	public interface Showable {
		void show();
	}

	public static class ShowGenger implements Showable {
		public ShowGenger(Showable target) {
			this.target = target;
		}

		private Showable target;

		@Override
		public void show() {
			System.out.println("show gender");
			System.out.println("===========");
			target.show();
		}
	}


	public static class ShowAge implements Showable {
		public ShowAge(Showable target) {
			this.target = target;
		}

		Showable target;

		@Override
		public void show() {
			System.out.println("show age");
			System.out.println("========");
			target.show();
		}
	}

	public static class ShowName implements Showable {
		@Override
		public void show() {
			System.out.println("show name");
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