package com.springboot.dbandcache.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.springboot.dbandcache.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("microservicesdb1.jdbc.driverClassName"));
        props.put("url", env.getProperty("microservicesdb1.jdbc.url"));
        props.put("username", env.getProperty("microservicesdb1.jdbc.username"));
        props.put("password", env.getProperty("microservicesdb1.jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);
        //指定基包
        fb.setTypeAliasesPackage("com.springboot.dbandcache.model");
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
        return fb.getObject();
    }
}
