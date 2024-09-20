package code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者 消费者 可以改成static
 */
public class ProducerConsumer {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<>();
    class Producer implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    queue.offer(1);
                    queue.notifyAll();;
                }
            }
        }
    }
    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while(queue.size() == 0) {
                        queue.notify();
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int item = queue.poll();
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Producer pro = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        new Thread(pro).start();
        new Thread(consumer).start();
    }
}
