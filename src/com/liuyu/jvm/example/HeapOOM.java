package com.liuyu.jvm.example;

import java.util.ArrayList;
import java.util.List;

/**   
 *  
 * @Description: 堆内存溢出（OutOfMemoryError: Java heap space）
 * args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author LiuYu   
 * @date 2015-4-11 上午11:09:46 
 *    
 */
public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}


