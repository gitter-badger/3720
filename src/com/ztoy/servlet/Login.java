package com.ztoy.servlet;

import com.ztoy.Cookie.LoginCookie;
import com.ztoy.DAO.UserDAO;
import com.ztoy.HBNT.HBNT;
import com.ztoy.MD5.MD5util;
import com.ztoy.Token.LoginToken;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录验证
 */
@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LoginToken.checkToken(request)) {
            try {
                response.setHeader("Content-type", "text/html;charset=UTF-8");//设置浏览器解析响应的格式
                response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                Transaction transaction = HBNT.getSession().beginTransaction();//开启事物

                String userName = request.getParameter("userName");
                String password = MD5util.encoderByMD5(request.getParameter("password"));

                if (UserDAO.login(userName,password)) {
                    out.println("恭喜您" + userName + "！登录成功！");

                    LoginCookie.addCookie(response,"userName",userName,604800);
                    LoginCookie.addCookie(response,"password",password,604800);
                } else {
                    out.println("对不起" + userName + "！用户名或密码不正确，请重新输入！");
                }
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
