package com.liuyu.jvm.example.concurrent;

/**
 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 * 例如假如线程1，线程2 在进行read,load 操作中，发现主内存中count的值都是5，那么都会加载这个最新的值
 * 在线程1堆count进行修改之后，会write到主内存中，主内存中的count变量就会变为6
 * 线程2由于已经进行read,load操作，在进行运算之后，也会更新主内存count的变量值为6
 * 导致两个线程及时用volatile关键字修改之后，还是会存在并发的情况。
 * Created by liuyu on 15-4-13.
 */
public class Counter {

    public volatile static int count =  0;

    public static void inc(){
        //延迟1毫秒，使结果明显
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (Counter.class){
            count ++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        //同时启动1000个线程去进行i++计算
        for (int i = 0; i < 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }

        Thread.sleep(1000);

        System.out.println("运算结果：Counter.count=" + Counter.count);
    }

}
