package code;

/**
 * 为什么要双重校验
 *
 * 双重检查是多个线程通过了第一次检查，一个线程先通过了第二次检查后边的线程不会再去实例化对象
 * volatile主要是禁止指令重排序,导致一个线程检查到对象不为null后，获取到未完全初始化的对象。
 */
public class DCLSingleton {
    private volatile static DCLSingleton singleton;
    private DCLSingleton (){}
    public static DCLSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if(singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
