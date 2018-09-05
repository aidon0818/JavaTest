package ThreadTest.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Dong_Liu
 * date：2017/10/12
 * 三个运动员各自准备，等到三个人都准备好后，再一起跑
 * 上面是一个形象的比喻，针对 线程 A B C 各自开始准备，直到三者都准备完毕，然后再同时运行 。
 * 也就是要实现一种 线程之间互相等待 的效果.
 * 先创建一个公共 CyclicBarrier 对象，设置 同时等待 的线程数，CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
 * 这些线程同时开始自己做准备，自身准备完毕后，需要等待别人准备完毕，这时调用 cyclicBarrier.await(); 即可开始等待别人；
 * 当指定的 同时等待 的线程数都调用了 cyclicBarrier.await();时，意味着这些线程都准备完毕好，然后这些线程才 同时继续执行。
 * 实现代码如下，设想有三个跑步运动员，各自准备好后等待其他人，全部准备好后才开始跑：
 */
public class CyclicBarrierTest {
    private static void runABCWhenAllReady() {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + "is preparing for time:" + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(rN + "is prepared, waiting for others");
                        cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + "starts running"); // 所有运动员都准备好了，一起开始跑
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest=new CyclicBarrierTest();
        cyclicBarrierTest.runABCWhenAllReady();
    }
}
