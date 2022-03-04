package com.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//开启dubbo的自动配置
@EnableDubbo //包含：@EnableDubboConfig
@SpringBootApplication
public class SpringbootDubboProviderApplication
{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboProviderApplication.class, args);
    }

}
