package com.bntang666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：BNTang
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/10 15:53
 * @description ：Goods-Cluster-01模块启动器
 */
@SpringBootApplication
@EnableEurekaClient
public class GoodsCluster01Application {

    public static void main(String[] args) {
        SpringApplication.run(GoodsCluster01Application.class, args);
    }

}