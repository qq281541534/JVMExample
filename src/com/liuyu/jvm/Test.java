package com.liuyu.jvm;
/**   
 *  
 * @Description: 
 * @author LiuYu   
 * @date 2015-3-29 下午4:43:39 
 *    
 */
public class Test {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.num1);
		System.out.println(singleton.num2);
		
	}
	
}


class Singleton{
	private static Singleton singleton = new Singleton();
	public static int num1;
	public static int num2 = 0;
	
	private Singleton(){
		num1++;
		num2++;
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
}

