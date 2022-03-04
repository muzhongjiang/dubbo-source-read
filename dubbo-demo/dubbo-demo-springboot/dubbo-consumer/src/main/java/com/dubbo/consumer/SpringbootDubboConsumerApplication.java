package com.dubbo.consumer;

import com.dubbo.consumer.component.DemoServiceComponent;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//开启dubbo的自动配置
@EnableDubbo //包含：@EnableDubboConfig
@SpringBootApplication
public class SpringbootDubboConsumerApplication
    implements CommandLineRunner
{

    @Autowired
    private DemoServiceComponent demoServiceComponent;

    @Override
    public void run(String... args) throws Exception
    {
        //调用：
        String hello = demoServiceComponent.sayHello("world");
        System.err.println("result :" + hello);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
    }
}
