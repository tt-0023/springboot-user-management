/*该类用于给密码加密，不再使用明文存密码，新增用户时，加密密码存入数据库，
登录时，把前端传的明文密码和数据库里加密后的密码比对，不能解密*/

package com.luna.myfirstcrud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //加密：明文密码->加密字符串，存入数据库
    public static String encode(String password) {
        return encoder.encode(password);
    }
    //校验：前端输入明文，和数据库密文对比
    public static boolean matches(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
