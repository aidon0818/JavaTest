package JavaTest;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int i=0; i<6; i++) {
            System.out.println(rand.nextInt(10));
        }
    }
}
