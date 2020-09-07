package com.bntang666.service;

import com.bntang666.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/7 19:57
 * @description
 **/
@FeignClient(name = "client-goods")
public interface GoodsFeignClient {
    @RequestMapping("/getGoods.do")
    ResponseResult getGoods();
}