package com.liuyu.jvm.example;
/**   
 *  
 * @Description: 虚拟机栈和本地方法栈溢出（stackOverFlow）
 * 单线程下，无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverFlowError
 * @author LiuYu   
 * @date 2015-4-11 上午11:46:01 
 *    
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}
}


