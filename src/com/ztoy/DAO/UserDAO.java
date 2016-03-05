package com.ztoy.DAO;

import com.ztoy.loginBean.User;

import java.util.List;

/**
 * 操作用户类的工具类
 */
public class UserDAO extends DAO {
    /**
     * 验证用户登录信息
     *
     * @param user 被验证的对象
     * @return 数据库中是否存在该对象
     */
    public static boolean login(User user) {
        String hql = "from User where userName = ? and password = ?";
        List list = select(hql, user.getUserName(), user.getPassword());
        return !list.isEmpty();
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
