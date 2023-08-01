package com.yscf.trade.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ComsumerSpringbootApplication {
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context=null;
         context =SpringApplication.run(ComsumerSpringbootApplication.class, args);

    }
}
