package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/9 10:19
 * @description
 **/
@SpringBootApplication
@EnableZuulProxy
public class Zuul8005Application {
    public static void main(String[] args) {
        SpringApplication.run(Zuul8005Application.class, args);
    }
}