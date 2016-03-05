package com.ztoy.servlet;

import com.ztoy.Cookie.LoginCookie;
import com.ztoy.DAO.UserDAO;
import com.ztoy.HBNT.HBNT;
import com.ztoy.MD5.MD5util;
import com.ztoy.loginBean.User;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

/**
 * 用户登录验证
 */
@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        try {
            user.setPassword(MD5util.encoderByMD5(request.getParameter("password")));
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            Transaction transaction = HBNT.getSession().beginTransaction();
            if (UserDAO.login(user)) {
                out.println("恭喜您" + user.getUserName() + "！登录成功！");

                LoginCookie.addCookie(response,"userName",user.getUserName(),604800);
                LoginCookie.addCookie(response,"password",user.getPassword(),604800);
            } else {
                out.println("对不起" + user.getUserName() + "！用户名或密码不正确，请重新输入！");
            }
            transaction.commit();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
