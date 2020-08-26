/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 14:10
 * Description .
 */
package hutool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 14:10
 * description 加密
 * @Auther: liudong
 */
public class SecureUtilTest {
    public static void main(String[] args) {
        String content = "test中文";

        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

        //加密
        byte[] encrypt = aes.encrypt(content);
        System.out.println("加密" + encrypt);
        //解密
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println("解密" + decrypt);

        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        //解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }
}