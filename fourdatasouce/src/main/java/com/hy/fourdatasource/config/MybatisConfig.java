package com.hy.fourdatasource.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = {"com.hy.fourdatasource.dao"})
public class MybatisConfig {

    @Bean("one")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource one(){
        return DataSourceBuilder.create().build();
    }

    @Bean("two")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource two(){
        return DataSourceBuilder.create().build();
    }

    @Bean("three")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.three")
    public DataSource three(){
        return DataSourceBuilder.create().build();
    }

    @Bean("four")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.four")
    public DataSource four(){
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("one",one());
        dataSourceMap.put("two",two());
        dataSourceMap.put("three",three());
        dataSourceMap.put("four",four());
        dynamicDataSource.setDefaultDataSource(one());
        dynamicDataSource.setDataSources(dataSourceMap);

        return dynamicDataSource;//TODO
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactory.setDataSource(dynamicDataSource());
        sessionFactory.setTypeAliasesPackage("com.hy.**.model");    // 扫描Model
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/map/*.xml"));    // 扫描映射文件
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }




}
