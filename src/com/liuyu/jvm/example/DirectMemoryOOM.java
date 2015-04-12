package com.liuyu.jvm.example;


import sun.misc.Unsafe;

/**   
 *  
 * @Description: 本机直接内存溢出
 * -Xmx20m -XX:MaxDirectMemorySize=10M
 * @author LiuYu   
 * @date 2015-4-11 下午6:44:22 
 *    
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		java.lang.reflect.Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}
}


