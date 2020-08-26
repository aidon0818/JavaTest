/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 10:23
 * Description .
 */
package hutool;

import cn.hutool.core.net.NetUtil;

import java.util.LinkedHashSet;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 10:23
 * description 在日常开发中，网络连接这块儿必不可少。日常用到的一些功能,隐藏掉部分IP地址、绝对相对路径的转换等等。
 * @Auther: liudong
 */
public class NetUtilTest {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        long iplong = 2130706433L;

        //根据long值获取ip v4地址
        String ip1 = NetUtil.longToIpv4(iplong);


        //根据ip地址计算出long型的数据
        long ip2 = NetUtil.ipv4ToLong(ip);

        //检测本地端口可用性
        boolean result = NetUtil.isUsableLocalPort(6379);

        //是否为有效的端口
        boolean result1 = NetUtil.isValidPort(6379);

        //隐藏掉IP地址
        String result2 = NetUtil.hideIpPart(ip);
        //获得本机的IP地址列表
        LinkedHashSet<String> ip3 = NetUtil.localIpv4s();
        System.out.println(ip3);
    }
}