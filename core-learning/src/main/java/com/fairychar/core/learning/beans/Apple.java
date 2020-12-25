// CHECKSTYLE:OFF

package com.fairychar.core.learning.beans;

import com.fairychar.core.learning.utils.WrapUtil;

/**
 * Datetime: 2020/12/18 12:50 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class Apple {
	private String color;

	public Apple(String color) {
		WrapUtil.wrapPrintln("apple constructure with 1 param");
		this.color = color;
	}

	public Apple() {
		WrapUtil.wrapPrintln("apple constructure");
	}


	public void  init(){
		WrapUtil.wrapPrintln("apple init method...");
	}

	public void eat(){
		WrapUtil.wrapPrintln("eat this apple(destroy)");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple{" +
				"color='" + color + '\'' +
				'}';
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