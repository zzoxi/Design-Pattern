package code;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

/**
 * 三个线程按照指定顺序执行
 */
public class ThreadTest {
        private ThreadTest() {}
        // 2.通过私有变量保存单例对象【添加了 volatile 修饰】
        private static  ThreadTest instance = null;
        // 3.提供公共获取单例对象的方法
        public static ThreadTest getInstance() {
            if (instance == null) { // 第 1 次效验
                synchronized (ThreadTest.class) {
                    if (instance == null) { // 第 2 次效验
                        instance = new ThreadTest();
                    }
                }
            }
            return instance;
        }

    public static void main(String[] args) {
            Thread t1 = new Thread(()->
            {
                ThreadTest instance1 = ThreadTest.getInstance();
            });
            t1.start();
            Thread t2 = new Thread(()->{
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ThreadTest instance2 = ThreadTest.getInstance();
            });
            t2.start();

    }

}
