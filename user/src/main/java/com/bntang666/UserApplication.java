package com.bntang666;

import com.bntang666.config.GoodsConfig;
import com.bntang666.config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableEurekaClient
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "CLIENT-GOODS", configuration = GoodsConfig.class),
        @RibbonClient(name = "SERVER-ORDER", configuration = OrderConfig.class)
})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
