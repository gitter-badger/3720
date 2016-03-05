package com.ztoy.HBNT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * hibernate连接获取工具类
 */
public class HBNT {
    private static SessionFactory sessionFactory;

    /**
     * 获取会话对象
     *
     * @return 返回会话对象
     */
    public static Session getSession() {
        if (sessionFactory != null) {
            return sessionFactory.getCurrentSession();
        }
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory.getCurrentSession();
    }
}
