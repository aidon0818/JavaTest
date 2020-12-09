package JavaTest;

public class Test2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(123);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
