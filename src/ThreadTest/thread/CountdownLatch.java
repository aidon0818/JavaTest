package ThreadTest.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dong_Liu
 * date：2017/10/12
 * 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 * 实现方法：
 * 创建一个计数器，设置初始值，CountdownLatch countDownLatch = new CountDownLatch(2);
 * 在 等待线程 里调用 countDownLatch.await() 方法，进入等待状态，直到计数值变成 0；
 * 在 其他线程 里，调用 countDownLatch.countDown() 方法，该方法会将计数值减小 1；
 * 当 其他线程 的 countDown() 方法把计数值变成 0 时，等待线程 里的 countDownLatch.await() 立即退出，继续执行下面的代码。
 * 其实简单点来说，CountDownLatch 就是一个倒计数器，我们把初始计数值设置为3，
 * 当 D 运行时，先调用 countDownLatch.await() 检查计数器值是否为 0，若不为 0 则保持等待状态；
 * 当A B C 各自运行完后都会利用countDownLatch.countDown()，将倒计数器减 1，当三个都运行完后，计数器被减至 0；
 * 此时立即触发 D 的 await() 运行结束，继续向下执行。
 * 因此，CountDownLatch 适用于一个线程去等待多个线程的情况。
 */
public class CountdownLatch {
    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + "is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + "finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        CountdownLatch countdownLatch = new CountdownLatch();
        countdownLatch.runDAfterABC();
    }
}
