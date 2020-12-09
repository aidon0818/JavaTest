package JavaTest;

public class Test1 {

    public static void sumArr(int... arr) {
        for (int i : arr) {
            System.out.print(i + "+");
        }
    }

    public static void main(String[] args) {
//        sumArr(2); //在这里传入一个数字，一串数字，一个数字数组都可以，很方便
//        sumArr(1, 2, 3);
        Double a=Double.parseDouble("0");
        System.out.println(a);
    }
}
