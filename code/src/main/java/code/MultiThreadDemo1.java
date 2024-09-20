package code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadDemo1 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();


        Thread t1 = new Thread(()->{
            while(true){
                lock.lock();
                try {
                    condition1.await();
                    System.out.println("a");
                    condition2.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });


        Thread t2 = new Thread(()->{
            while(true){
                lock.lock();
                try {
                    condition2.await();
                    System.out.println("b");
                    condition3.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t3 = new Thread(()->{
            while(true){
                lock.lock();
                try {
                    condition3.await();
                    System.out.println("c");
                    condition1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();
        condition1.signal();
        lock.unlock();


    }

}
