/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/25 16:26
 * Description .
 */
package hutool;

import cn.hutool.core.map.BiMap;
import cn.hutool.core.map.MapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * CreateDate 2020/8/25 16:26
 * description
 * @Auther: liudong
 */
public class MapUtilTest {
    public static void main(String[] args) {
        Map<Object, Object> colorMap = MapUtil.of(new String[][]{
                {"RED", "#FF0000"},
                {"GREEN", "#00FF00"},
                {"BLUE", "#0000FF"}
        });

        List ls = new ArrayList();
        Map<Object, Object> a = MapUtil.of(new String[][]{
                {"a", "1"},
                {"b", "2"},
                {"c", "3"}
        });
        Map<Object, Object> b = MapUtil.of(new String[][]{
                {"a", "1"},
                {"b", "2"}
        });
        Map<Object, Object> c = MapUtil.of(new String[][]{
                {"a", "1"},
                {"b", "3"}
        });
        ls.add(a);
        ls.add(b);
        ls.add(c);
        //Map的键和值互换
        System.out.println(MapUtil.reverse(colorMap));

        //toListMap 行转列
        System.out.println(MapUtil.toListMap(ls));

        //toMapList 列转行

        //即根据key查找value和根据value查找key，Hutool也同样提供此对象。
        BiMap<String, String> biMap = new BiMap<>(new HashMap<>());
        biMap.put("aaa", "a");
        biMap.put("bbb", "b");
        System.out.println(biMap.getKey("b"));
    }
}