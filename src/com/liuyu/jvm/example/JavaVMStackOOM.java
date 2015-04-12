package com.liuyu.jvm.example;
/**   
 *  
 * @Description: 创建线程导致内存溢出异常（OutOfMemoryError:unable to create new native thread）
 * 每个线程在分配到的栈容量越大，可以建立的线程数量就越少，建立线程时就越容易把剩下的内存耗尽。
 * 解决办法：如果建立过多线程导致内存溢出，在不能减少线程数量或者更换64位虚拟机的情况下，就只能通过减少最大堆和减少栈容量来换取更多的线程。
 * @author LiuYu   
 * @date 2015-4-11 下午12:03:24 
 *    
 */
public class JavaVMStackOOM {

	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){

				@Override
				public void run() {
					dontStop();
				}
				
			});
			thread.start();
		}
	}
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}


