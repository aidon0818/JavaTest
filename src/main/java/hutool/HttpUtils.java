/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/12/9 9:55
 * Description .
 */
package hutool;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @author LiuDong
 * @Version: 1.0.0
 * @Date: 2020/12/9 9:55
 * Description .
 */
public class HttpUtils {
    public static void main(String[] args) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result3 = HttpUtil.get("https://www.baidu.com", paramMap);
        System.out.println(result3);
    }
}