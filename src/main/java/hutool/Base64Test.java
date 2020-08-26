/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/25 17:10
 * Description .
 */
package hutool;

import cn.hutool.core.codec.Base64;

/**
 * @version 1.0.0
 * CreateDate 2020/8/25 17:10
 * description
 * @Auther: liudong
 */
public class Base64Test {
    public static void main(String[] args) {
        String a = "伦家是一个非常长的字符串";
        //5Lym5a625piv5LiA5Liq6Z2e5bi46ZW/55qE5a2X56ym5Liy
        String encode = Base64.encode(a);
        System.out.println(encode);
        // 还原为a
        String decodeStr = Base64.decodeStr(encode);
        System.out.println(decodeStr);
    }
}