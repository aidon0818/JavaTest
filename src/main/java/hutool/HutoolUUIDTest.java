/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/25 14:17
 * Description .
 */
package hutool;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @version 1.0.0
 * CreateDate 2020/8/25 14:17
 * description
 * @Auther: liudong
 */
public class HutoolUUIDTest {
    public static void main(String[] args) {
        //ObjectId是MongoDB数据库的一种唯一ID生成策略
        String id = ObjectId.next();
        System.out.println(id);

        String id2 = IdUtil.objectId();
        System.out.println(id2);

        //UUID全称通用唯一识别码（universally unique identifier）
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println(simpleUUID);

        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id3 = snowflake.nextId();

        System.out.println(id3);
    }
}