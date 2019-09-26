package com.hy.fourdatasource.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)  // 该切面应当先于 @Transactional 执行
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(dataSource))")
    public void switchDataSource(JoinPoint point, DataSource dataSource){
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dataSource.value())) {
            System.out.println("DataSource [{}] doesn't exist, use default DataSource [{}] " + dataSource.value());
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value());
            System.out.println("Switch DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey()
                    + "] in Method [" + point.getSignature() + "]");
        }
    }

    @After("@annotation(dataSource))")
    public void storeDataSource(JoinPoint point, DataSource dataSource){
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }
}
