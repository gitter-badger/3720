package com.ztoy.Token;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 用时间戳来防止表单重复提交
 */
public class LoginToken {
    /**
     * 获取当前时间的时间戳
     * @return 时间戳的字符串
     */
    public static String getToken(){
        return new Date().getTime() + "";
    }

    /**
     * 验证时间戳如果成功返回true并删除token
     * @param request 请求对象
     * @return 验证结果
     */
    public static boolean checkToken(HttpServletRequest request){
        String string = request.getParameter("token");
        if (string != null) {
            HttpSession session = request.getSession();
            if (string.equals(session.getAttribute("token"))){
                session.removeAttribute("token");
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 种下token，并返回token的值
     * @param session 种到这个session
     * @return token值
     */
    public static String setToken(HttpSession session){
        String s = getToken();
        session.setAttribute("token",s);
        return s;
    }
}
