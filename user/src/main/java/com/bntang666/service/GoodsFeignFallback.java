package com.bntang666.service;

import com.bntang666.util.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/8 19:08
 * @description
 **/
@Component
public class GoodsFeignFallback implements GoodsFeignClient {

    @Override
    public ResponseResult getGoods() {
        return ResponseResult.error("GoodsFeignFallback服务器正在维护，请稍后重试");
    }
}