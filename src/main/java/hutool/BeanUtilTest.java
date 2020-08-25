/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/25 14:33
 * Description .
 */
package hutool;

import Dozer.StudentDomain;
import Dozer.StudentVo;
import cn.hutool.core.bean.BeanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * CreateDate 2020/8/25 14:33
 * description
 * @Auther: liudong
 */
public class BeanUtilTest {
    public static void main(String[] args) {
        StudentVo studentVo = new StudentVo();
        studentVo.setId(123L);
        studentVo.setName("aaa");
        StudentDomain a = new StudentDomain();
        BeanUtil.copyProperties(studentVo, a);
        System.out.println(a.getName());

        Map<String, Object> map = new HashMap<>();
        BeanUtil.copyProperties(studentVo, map);
        System.out.println(map);


    }
}