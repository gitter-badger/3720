package com.ztoy.DAO;

import com.ztoy.HBNT.HBNT;
import org.hibernate.Query;

import java.util.List;

/**
 * 操作javabean的工具类
 */
public class DAO {
    /**
     * 保存对象到数据库
     *
     * @param o 被保存对象
     */
    public static void save(Object o) {
        HBNT.getSession().save(o);
    }

    /**
     * 从数据库中查找对象
     *
     * @param hql  预编译查询语句
     * @param args 查询语句参数
     * @return 结果集
     */
    public static List select(String hql, Object... args) {
        Query query = HBNT.getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query.list();
    }
}
