package com.ztoy.servlet;

import com.ztoy.DAO.UserDAO;
import com.ztoy.HBNT.HBNT;
import com.ztoy.MD5.MD5util;
import com.ztoy.Token.LoginToken;
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
 * 用户注册验证
 */
@WebServlet(name = "Sign",urlPatterns = "/sign")
public class Sign extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LoginToken.checkToken(request)) {
            Transaction transaction = HBNT.getSession().beginTransaction();
            response.setHeader("Content-type", "text/html;charset=UTF-8");//设置网页应该用什么格式显示响应结果
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String userName = request.getParameter("userName");
            if (UserDAO.logon(userName)){//验证用户名是否存在
                out.println("用户名"+userName+"已存在！");
            }else {
                User user = new User();
                user.setUserName(userName);
                try {
                    user.setPassword(MD5util.encoderByMD5(request.getParameter("password")));//用MD5计算后存储密码的MD5值
                    UserDAO.save(user);
                    out.println("恭喜您"+userName+"！注册成功!");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            transaction.commit();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
