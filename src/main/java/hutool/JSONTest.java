/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 13:43
 * Description .
 */
package hutool;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 13:43
 * description
 * @Auther: liudong
 */
public class JSONTest {
    public static void main(String[] args) {
        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
        System.out.println(json1);

        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        //方法一：使用工具类转换,可以判断是否保持原有顺序，第三个参数
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr, false, true);
        //方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);

        String str = JSONUtil.toJsonStr(jsonObject);
        System.out.println(str);

        //方法1
        JSONArray array = JSONUtil.createArray();
        //方法2
        //JSONArray array = new JSONArray();

        array.add("value1");
        array.add("value2");
        array.add("value3");

        //转为JSONArray字符串
        array.toString();
        System.out.println(array);

        String jsonStr1 = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array1 = JSONUtil.parseArray(jsonStr1);
        System.out.println(array1);
    }
}