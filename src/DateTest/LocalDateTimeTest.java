package DateTest;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Dong_Liu
 * date：2017/10/13
 * 1.8---新时间类
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime date=LocalDateTime.now();
        System.out.println(date.toString());
        System.out.println(date.getYear()+"年");
        System.out.println(date.getMonthValue()+"月");
        System.out.println(date.getDayOfMonth()+"日");
        System.out.println(date.getHour()+"时");
        System.out.println(date.getMinute()+"分");
        System.out.println(date.getSecond()+"秒");
    }
}
