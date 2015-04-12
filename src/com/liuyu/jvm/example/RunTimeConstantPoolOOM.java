package com.liuyu.jvm.example;


/**   
 *  
 * @Description: 运行时常量池导致的内存溢出异常(OutOfMemoryError： PermGen space)
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * String.intern()是一个Native方法，作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
 * 否则将此String对象包含的字符串添加到常量池中，并返回此对象的引用。
 * @author LiuYu   
 * @date 2015-4-11 下午5:37:28 
 *    
 */
public class RunTimeConstantPoolOOM {
	
	//在JDK1.7中该方法不会抛出异常，1.6可以
	/*public static void main(String[] args) {
		//使用List保持着常量池引用，避免FULL GC回收常量池
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}*/
	
	/**
	 * jdk1.6返回两false，因为intern方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串的实例引用，而StringBuilder创建的对象
	 * 		在java堆上，所有是false。
	 * 
	 * jdk1.7返回true和false
	 * 因为1.7中，intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder创建的字符串实例是同一个，
	 * str2返回false是因为new StringBuilder("计算机").append("软件").toString()在str1时已经出现过，字符串常量池中已经有它的引用，不符合
	 * “首次出现”的原则，所以是false
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str1= new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str2.intern() == str2);
	}
	
	
}


