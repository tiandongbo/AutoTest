package com.huawei.mes.util.db;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;
/**
 * ClassName DruidDataSourceFactory
 * Description
 * Create by tiandongbo 00350982
 * Date 2021/4/27 16:36
 */

public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public DataSource getDataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(this.props.getProperty("driver"));
        dds.setUrl(this.props.getProperty("url"));
        dds.setUsername(this.props.getProperty("username"));
        dds.setPassword(this.props.getProperty("password"));
        try {
            dds.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dds;
    }

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }
}
