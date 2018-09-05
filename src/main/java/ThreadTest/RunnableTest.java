package ThreadTest;

/*
 * 地址：http://blog.csdn.net/lianqiangjava/article/details/12652201/
*/
public class RunnableTest {
	public static class Runnable_demo implements Runnable {
		//定义票数
		private int ticket = 10;
		public void run() {
			//i代表循环几次start
			for (int i = 0; i < 5 ; i++) {
				if (this.ticket > 0) {
					// 休眠1s秒中，为了使效果更明显，否则可能出不了效果
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.sale();
				}

			}
		}

		public synchronized void sale() {
			if (this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "号窗口卖出：" + this.ticket-- + "号票");
			}
		}

		public static void main(String args[]) {
			Runnable_demo demo = new Runnable_demo();
			// 基于火车票创建三个窗口
			new Thread(demo, "a").start();
			new Thread(demo, "b").start();
			new Thread(demo, "c").start();
		}
	}
}
