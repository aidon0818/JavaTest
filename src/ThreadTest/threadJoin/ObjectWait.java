package ThreadTest.threadJoin;

/**
 * Created by Dong_Liu
 * date：2017/10/12
 * 那如何让 两个线程按照指定方式有序交叉运行呢？
 * 还是上面那个例子，我现在希望 A 在打印完 1 后，
 * 再让 B 打印 1, 2, 3，最后再回到 A 继续打印 2, 3。
 * 这种需求下，显然 Thread.join() 已经不能满足了。我们需要更细粒度的锁来控制执行顺序。
 * 这里，我们可以利用 object.wait() 和 object.notify() 两个方法来实现。代码如下：
 */
public class ObjectWait {
    /**
     * A 1, B 1, B 2, B 3, A 2, A 3
     */
    /**
     * 首先创建一个 A 和 B 共享的对象锁 lock = new Object();
     * 当 A 得到锁后，先打印 1，然后调用 lock.wait() 方法，交出锁的控制权，进入 wait 状态；
     * 对 B 而言，由于 A 最开始得到了锁，导致 B 无法执行；直到 A 调用 lock.wait() 释放控制权后， B 才得到了锁；
     * B 在得到锁后打印 1， 2， 3；然后调用 lock.notify() 方法，唤醒正在 wait 的 A;
     * A 被唤醒后，继续打印剩下的 2，3。
     */
    private static void demo3() {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        B.start();
        A.start();
    }

    public static void main(String[] args) {
        ObjectWait objectWait = new ObjectWait();
        objectWait.demo3();
    }
}
