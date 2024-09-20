package code;

import java.sql.SQLOutput;

public class ABC {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("A");
        });
        Thread t2 = new Thread(()->{
            System.out.println("B");
        });
        Thread t3 = new Thread(()->{
            System.out.println("C");
        });
        t1.start();
    }
}
