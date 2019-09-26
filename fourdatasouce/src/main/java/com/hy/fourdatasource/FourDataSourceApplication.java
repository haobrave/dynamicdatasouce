package com.hy.fourdatasource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.hy.fourdatasource")
public class FourDataSourceApplication {
    public static void main(String[] input){
        SpringApplication.run(FourDataSourceApplication.class);
    }
}
