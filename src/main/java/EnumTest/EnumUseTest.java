package EnumTest;

/**
 * Created by Aidon on 17/8/3.
 */
public class EnumUseTest {
    public static void main(String[] args) {
        //输出某一枚举的值
        System.out.println(EnumTest.RED.getName());
        System.out.println(EnumTest.RED.getIndex());

        //遍历所有的枚举
        for (EnumTest color : EnumTest.values()) {
            System.out.println(color + "  name: " + color.getName() + "  index: " + color.getIndex());
        }
    }
}
