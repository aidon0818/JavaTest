package ThreadTest;

public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }
    /**
     * 接收线程池发来的任务，并执行
     */
    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
