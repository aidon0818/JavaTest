package ThreadTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("进入守护线程" + Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程" + Thread.currentThread().getName());
	}

	private void writeToFile() throws Exception {
//		File fileName = new File("Downloads:" + File.separator + "daemon.txt");
//		OutputStream os = new FileOutputStream(fileName, true);// 每次新增不是覆盖
		int count = 0;
		while (count < 999) {
//			os.write(("\r\n" + count).getBytes());
			System.out.println("守护线程" + count);
			count++;
			Thread.sleep(1000);
		}
	}

}

public class DaemonThreadDemo {
	public static void main(String[] args) {
		System.out.println("进入主线程" + Thread.currentThread().getName());
		DaemonThread daemonThread = new DaemonThread();
		Thread thread = new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		Scanner sc = new Scanner(System.in);
		sc.next();
		System.out.println("退出主线程" + Thread.currentThread().getName());
	}
}
