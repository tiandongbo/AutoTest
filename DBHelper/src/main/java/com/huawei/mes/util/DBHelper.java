package com.huawei.mes.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ClassName GaussHelper
 * Description
 * Create by tiandongbo 00350982
 * Date 2021/4/30 20:59
 */
public class DBHelper {
    private final static Log log = LogFactory.getLog(DBHelper.class);
    //定义连接资源
    private static Connection ct = null;
    private static PreparedStatement ps = null;
    private static CallableStatement cs = null;
    private static ResultSet rs = null;

    //定义配置参数
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static String driver = "com.huawei.gauss.jdbc.inner.GaussDriver";

    private static Properties pp = null;
    private static InputStream is = null;

    //读取配置参数，加载驱动
    static {
        try {
            pp = new Properties();
            is = DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties");
            if (is == null) {
                is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
            }
            pp.load(is);
            driver = pp.getProperty("driver");
            url = pp.getProperty("url");
            username = pp.getProperty("username");
            password = pp.getProperty("password");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("没有找到驱动程序!", e);
            System.out.println(" 没有找到驱动程序! 所需的驱动程序为： " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "读取数据库连接配置文件jdbc.properties失败! 查找的配置文件路径为：%s";
            msg = String.format(msg, DBHelper.class.getClassLoader().getResource("").getPath());
            log.error(msg, e);
            System.out.println(msg);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
            is = null;
        }
    }


    //获取连接
    public static Connection getConnection() {
        try {
            ct = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
        }
        return ct;
    }

    //关闭所有资源连接
    public static void close(Connection ct, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
            rs = null;
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
            ps = null;
        }
        if (null != ct) {
            try {
                ct.close();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
            ct = null;
        }
    }


    //执行DQL查询
    public static ResultSet executeQuery(String sql, String[] parameters) {
        try {
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
            throw new RuntimeException(e.getMessage());
        }
        return rs;
    }

    //执行DML更新
    public static int executeUpdate(String sql, String[] parameters) {
        try {
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);
                }
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e);
            throw new RuntimeException(e.getMessage());
        } finally {
            close(ct, ps, rs);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}
