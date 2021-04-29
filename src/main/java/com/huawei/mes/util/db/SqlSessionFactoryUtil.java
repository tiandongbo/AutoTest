package com.huawei.mes.util.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ClassName SqlSessionFactoryUtil
 * Description
 * Create by tiandongbo 00350982
 * Date 2021/4/27 16:40
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;


    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static SqlSession getOpenSession() {
        SqlSession session=null;
        try {
            session = sqlSessionFactory.openSession(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return session;
    }



    public static <T> T getTestMapper(Class<T> type) {
        return getOpenSession().getMapper(type);

    }
}
