package com.bntang666.service;

import com.bntang666.util.ResponseResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/8 19:18
 * @description
 **/
@Component
public class GoodsFeignFallBackFactory implements FallbackFactory<GoodsFeignClient> {
    @Override
    public GoodsFeignClient create(Throwable cause) {
        return () -> {
            String message = cause.getMessage();
            return ResponseResult.error(message);
        };
    }
}