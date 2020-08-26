/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 14:26
 * Description .
 */
package hutool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.security.KeyPair;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 14:26
 * description 非对称加密
 * @Auther: liudong
 */
public class AsymmetricCryptoTest {
    public static void main(String[] args) {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        System.out.println(pair.getPrivate());

        pair.getPublic();
        RSA rsa = new RSA();
        //公钥加密，私钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

        //私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
        String ss = StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8);
        System.out.println(ss);
    }
}