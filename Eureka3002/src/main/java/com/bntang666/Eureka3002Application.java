package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：tangyihao
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/13 15:49
 * @description ：
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka3002Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka3002Application.class, args);
    }
}