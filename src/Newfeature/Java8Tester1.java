package Newfeature;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aidon on 18/8/6.
 */
public class Java8Tester1 {
    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
