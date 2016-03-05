<%@ page import="com.ztoy.Cookie.LoginCookie" %>
<%@ page import="com.ztoy.loginBean.User" %>
<%@ page import="com.ztoy.DAO.UserDAO" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.ztoy.HBNT.HBNT" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录模块</title>
</head>
<body>
<%
    Transaction transaction = HBNT.getSession().beginTransaction();
    User user = new User();
    Cookie[] cookie = request.getCookies();//获取cookie
    user.setUserName(LoginCookie.findCookie(cookie, "userName"));//查找cookie中的用户名和密码并放入user
    user.setPassword(LoginCookie.findCookie(cookie, "password"));
    if (UserDAO.login(user)) {
        out.println("欢迎您" + user.getUserName());
%>
<a href="${pageContext.request.contextPath}/exit">退出登录</a>
<%
} else {
%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>用户名:
        <input type="text" name="userName"/>
    </label>
    <label>密码:
        <input type="password" name="password"/>
    </label>
    <input type="submit" value="登录">
</form>
<a href="sign.jsp">注册</a>
<%

    }
    transaction.commit();
%>
</body>
</html>
