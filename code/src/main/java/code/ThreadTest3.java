package code;

public class ThreadTest3 {
    private static final Object lock = new Object();
    private static int count = 0;
    private static final int MAX_COUNT = 30;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count >= MAX_COUNT) {
                        break;
                    }
                    System.out.print("A ");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count >= MAX_COUNT) {
                        break;
                    }
                    System.out.print("B ");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count >= MAX_COUNT) {
                        break;
                    }
                    System.out.print("C ");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

