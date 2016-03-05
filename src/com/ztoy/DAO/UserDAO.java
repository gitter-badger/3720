package com.ztoy.DAO;

import com.ztoy.loginBean.User;

import java.util.List;

/**
 * 操作用户类的工具类
 */
public class UserDAO extends DAO {
    public static boolean login(User user) {
        String hql = "from User where userName = ? and password = ?";
        List list = select(hql, user.getUserName(), user.getPassword());
        return !list.isEmpty();
    }

    public static boolean logon(String userName) {
        String hql = "select userName from User where userName = ?";
        List list = select(hql, userName);
        return !list.isEmpty();
    }
}
