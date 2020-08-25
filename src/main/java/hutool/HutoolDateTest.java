/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/25 14:05
 * Description .
 */
package hutool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0.0
 * CreateDate 2020/8/25 14:05
 * description
 * @Auther: liudong
 */
public class HutoolDateTest {
    public static void main(String[] args) {
        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();

        System.out.println(now);

        System.out.println(today);

        Date date1 = DateUtil.date();
        //获得年的部分
        System.out.println(DateUtil.year(date1));
        //获得月份，从0开始计数
        System.out.println(DateUtil.month(date1));
        //获得月份枚举
        System.out.println(DateUtil.quarter(date1));
        String chineseZodiac = DateUtil.getChineseZodiac(1988);
        System.out.println(chineseZodiac);

        System.out.println(DateTime.of(1298143095606611968L));
    }
}