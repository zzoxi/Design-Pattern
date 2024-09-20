package code;

import java.util.concurrent.Semaphore;

public class ThreadTest2 {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);
    private static final int MAX_COUNT = 30;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < MAX_COUNT; i++) {
                try {
                    semaphoreA.acquire();
                    System.out.print("A ");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < MAX_COUNT; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.print("B ");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < MAX_COUNT; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.print("C ");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
