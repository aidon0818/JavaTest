/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/10/15 16:47
 * Description .
 */
package LambdaTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * CreateDate 2020/10/15 16:47
 * description
 * @Auther: liudong
 */
public class reduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素只和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求和
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最大值
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最小值
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Optional.of(result2).ifPresent(System.out::println);
    }
}