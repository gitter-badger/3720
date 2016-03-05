package com.ztoy.DES;

import com.ztoy.MD5.MD5util;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * zuo 在 2016/3/5所敲;
 */
public class KEYTest {
    @Test
    public void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String a = "zuozijian";
        System.out.println("MD5："+ MD5util.encoderByMD5(a));
//        User user = new User();
//        user.setUserName("zuo");
//        user.setPassword(MD5util.encoderByMD5("zuozijian"));
//        Transaction transaction = HBNT.getSession().beginTransaction();
//        UserDAO.save(user);
//        transaction.commit();
    }

}