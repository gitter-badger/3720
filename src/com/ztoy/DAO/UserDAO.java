package com.ztoy.DAO;

import java.util.List;

/**
 * 操作用户类的工具类
 */
public class UserDAO extends DAO {
    /**
     * 验证用户登录信息
     *
     * @param userName 用户名
     * @param password 密码
     * @return 数据库中是否存在该对象
     */
    public static boolean login(String userName, String password) {
        if (userName != null && password != null) {
            String hql = "from User where userName = ? and password = ?";
            List list = select(hql, userName, password);
            return !list.isEmpty();
        } else {
            return false;
        }
    }

    /**
     * 验证用户名
     *
     * @param userName 验证对象
     * @return 数据库中是否存在该用户名
     */
    public static boolean logon(String userName) {
        String hql = "select userName from User where userName = ?";
        List list = select(hql, userName);
        return !list.isEmpty();
    }
}
