package com.lizhenfang.yuekao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class GatwayStart {
    public static void main(String[] args) {
        SpringApplication.run(GatwayStart.class,args);
    }
}