package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/7 10:17
 * @description
 **/
@SpringBootApplication
@EnableEurekaClient
public class Order1Application {
    public static void main(String[] args) {
        SpringApplication.run(Order1Application.class, args);
    }
}
