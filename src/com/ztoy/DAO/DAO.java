package com.ztoy.DAO;

import com.ztoy.HBNT.HBNT;
import org.hibernate.Query;

import java.util.List;

/**
 * 操作javabean的工具类
 */
public class DAO {
    public static void save(Object o){
        HBNT.getSession().save(o);
    }
    public static List select(String hql,Object...args){
        Query query = HBNT.getSession().createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query.list();
    }
}
