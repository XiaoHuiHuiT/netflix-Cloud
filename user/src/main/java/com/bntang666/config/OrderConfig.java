package com.bntang666.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/7 13:10
 * @description
 **/
@Configuration
public class OrderConfig {

@Bean
public IRule iRule() {
    return new RoundRobinRule();
}

}
