package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：BNTang
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/10 15:53
 * @description ：Goods模块启动器
 */
@SpringBootApplication
@EnableEurekaClient
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

}