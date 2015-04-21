package com.liuyu.jvm.example.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存监控的示例代码
 * args: -Xms100m -Xmx100m -XX:+UseSerialGC
 * Created by liuyu on 15-4-21.
 */
public class JConsole {

    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i = 0; i < num; i++){
            //稍作延迟，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
