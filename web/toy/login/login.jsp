<%@ page import="com.ztoy.Cookie.LoginCookie" %>
<%@ page import="com.ztoy.loginBean.User" %>
<%@ page import="com.ztoy.DAO.UserDAO" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.ztoy.HBNT.HBNT" %>
<%@ page import="org.apache.el.parser.Token" %>
<%@ page import="com.ztoy.Token.LoginToken" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录模块</title>
</head>
<body>
<%
    //利用cookie自动登录
    Transaction transaction = HBNT.getSession().beginTransaction();
    Cookie[] cookie = request.getCookies();//获取cookie
    String userName = (LoginCookie.findCookie(cookie, "userName"));//查找cookie中的用户名和密码并放入user
    String password = (LoginCookie.findCookie(cookie, "password"));
    if (UserDAO.login(userName, password)) {
        out.println("欢迎您" + userName);
%>
<a href="${pageContext.request.contextPath}/exit">退出登录</a>
<%
} else {
%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input name="token" value="<%=LoginToken.setToken(session)//种下token防止重复提交%>" type="hidden"/>
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
