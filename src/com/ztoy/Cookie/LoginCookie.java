package com.ztoy.Cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 */
public class LoginCookie {
    /**
     * 从cookie数组中找到名为str的cookie的值
     *
     * @param cookies cookie数组
     * @param str     需要查找的cookie名
     * @return 查找到的cookie值
     */
    public static String findCookie(Cookie[] cookies, String str) {
        String value = null;
        if (cookies != null && cookies.length > 0)
            for (Cookie cookie : cookies) {
                if (str.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        return value;
    }

    /**
     * 把名为name值为value持续时间为time的cookie插入到response响应中
     *
     * @param response 响应
     * @param name     cookie名
     * @param value    cookie值
     * @param time     cookie持续时间
     */
    public static void addCookie(HttpServletResponse response, String name, String value, Integer time) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }
}
