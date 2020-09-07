package com.bntang666.config;

import com.bntang666.config.irule.MyIRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：BNTang
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/10 13:04
 * @description ：配置类
 */
@Configuration
public class UserAppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TomcatServletWebServerFactory tomcat() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(4000);
        return tomcat;
    }

    @Bean
    public IRule iRule() {
        return new MyIRule();
    }
}
