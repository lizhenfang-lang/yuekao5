package com.lizhenfang.yuekao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerStart {
    public static void main(String[] args) {
        SpringApplication.run(ServerStart.class,args);
    }
}
