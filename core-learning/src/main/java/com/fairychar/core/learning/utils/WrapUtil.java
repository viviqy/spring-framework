package com.fairychar.core.learning.utils;

import java.util.stream.IntStream;

/**
 * Datetime: 2020/12/24 12:44 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public final class WrapUtil {

	public static void beautyToString(Object o){
		String className = o.getClass().getName();

	}

	public static void wrapPrintln(String text) {
		System.out.println();
		IntStream.range(0, text.length() + 6).forEach(s -> {
			System.out.print("=");
		});
		System.out.println();
		System.out.println("|| " + text + " ||");
		IntStream.range(0, text.length() + 6).forEach(s -> {
			System.out.print("=");
		});
		System.out.println();
	}

	private WrapUtil() {
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