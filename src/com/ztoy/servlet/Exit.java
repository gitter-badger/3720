package com.ztoy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录
 */
@WebServlet(name = "Exit",urlPatterns = "/exit")
public class Exit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null&&cookies.length>0)
            for (Cookie cookie:cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            }
        response.sendRedirect("/toy/login/login.jsp");
    }
}
