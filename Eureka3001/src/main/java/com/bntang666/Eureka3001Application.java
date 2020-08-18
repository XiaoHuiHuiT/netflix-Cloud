package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：tangyihao
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/13 15:42
 * @description ：
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka3001Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka3001Application.class, args);
    }
}