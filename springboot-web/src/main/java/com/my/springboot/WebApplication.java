package com.my.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@ComponentScan(basePackages = {"com.my.springboot"})
@SpringBootApplication
@PropertySource(value = {"classpath:config/${spring.profiles.active}/application.properties"})
public class WebApplication {
    public static void main(String [] args){

        SpringApplication.run(WebApplication.class, args);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
