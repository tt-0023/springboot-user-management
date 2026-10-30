package com.luna.myfirstcrud;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import io.jsonwebtoken.Jwts;

public class JwtUti {
    //密钥
    private static final SecretKey KEY= Keys.hmacShaKeyFor(
            "abcdefghijklmopqrstuvwxyz1234567890".getBytes( )
    );
    //token有效期：one week
    private static final long EXPIRATION_TIME=1000*60*60*24*7;
    //生成token，存入用户id
    public static String generateToken(Long userId){
        Date now=new Date();
        Date expiryDate=new Date(now.getTime()+EXPIRATION_TIME);//过期时间
        return Jwts.builder()
                .setSubject(userId.toString())//载体存放用户id
                .setIssuedAt(now)//签发时间
                .setExpiration(expiryDate)//过期时间
                .signWith(KEY)/*生成签名，role:把前面设置的payload（用户id、签发时间、过期时间）连同头部一起，使用KEY进行签名
                 这是JWT安全性的核心，防止token被篡改
                */
                .compact();/*把构建好的JWT对象转换成最终字符串格式（eg:xxxxx.yyyyy.zzzzz这种用点分割的三段式字符串）
                这个字符串就是最终返回给前端保存的token
                */
    }
    //解析token,获取用户id
    public static Long getUserId(String token){
        Claims claims=Jwts.parser()
                .setSigningKey(KEY)//设置签名密钥
                .build()//构建解析器
                .parseClaimsJws(token)//解析token,验证签名且判断token是否过期
                .getBody();//获取载荷（payload)，解析成功后返回Claims对象

        return Long.valueOf(claims.getSubject());
    }
    //校验token是否合法、未过期
    public static boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(KEY).build().parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
