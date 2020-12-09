/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/27 17:51
 * Description .
 */
package hutool;

import cn.hutool.system.SystemUtil;

import java.util.Vector;

/**
 * @version 1.0.0
 * CreateDate 2020/8/27 17:51
 * description
 * @Auther: liudong
 */
public class SystemUtilTest {
    public static void main(String[] args) {
        System.out.println(SystemUtil.getJvmSpecInfo());
        System.out.println(SystemUtil.getJvmInfo());
        System.out.println(SystemUtil.getJavaRuntimeInfo());
        System.out.println(SystemUtil.getUserInfo());
        Vector l = new Vector();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        for (Object o : l) {
            System.out.println(o);
        }

    }
}