package com.ztoy.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *MD5工具类
 */
public class MD5util {
    /**
     * 把字符串用MD5摘要计算返回摘要字符串
     *
     * @param str 需要计算摘要的字符串
     * @return MD5值
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String encoderByMD5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return Base64.getEncoder().encodeToString(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
    }
}
