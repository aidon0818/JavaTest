/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 17:05
 * Description .
 */
package hutool;

import cn.hutool.extra.pinyin.PinyinUtil;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 17:05
 * description
 * @Auther: liudong
 */
public class PinyinUtilTest {
    public static void main(String[] args) {
        // "ni hao"
        String pinyin = PinyinUtil.getPinyin("你好", " ");
        System.out.println(pinyin);
        //获取拼音首字母
        String result = PinyinUtil.getFirstLetter("H是第一个", ", ");
        System.out.println(result);
    }
}