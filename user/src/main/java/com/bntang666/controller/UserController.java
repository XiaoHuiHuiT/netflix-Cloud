package com.bntang666.controller;

import com.bntang666.service.GoodsFeignClient;
import com.bntang666.util.ResponseResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author ：BNTang
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/10 12:59
 * @description ：User相关的服务
 */
@RestController
public class UserController {

    //    @RequestMapping("/getGoods.do")
//    public ResponseResult getGoods() {
//        return ResponseResult.success("调用Goods服务成功", restTemplate.getForObject("http://localhost:80/getGoods.do", Object.class));
//    }
    @Autowired
    public RestTemplate restTemplate;
    private static final String GOODS_URL = "http://client-goods";

    @Autowired
    private GoodsFeignClient goodsFeignClient;

    @RequestMapping("/getGoods.do")
    @HystrixCommand(
            fallbackMethod = "fallbackMethod",
            threadPoolKey = "goods-2",
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "5")}
    )
    public ResponseResult getGoods() {
        return ResponseResult.success("调用Goods服务成功", this.restTemplate.getForObject(GOODS_URL + "/getGoods.do", Object.class));
    }

    public ResponseResult fallbackMethod() {
        return ResponseResult.error("服务器正在维护，请稍后重试");
    }

    @RequestMapping("/getUser.do")
    public ResponseResult getUser() {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "BNTangUser");
        return ResponseResult.success("获取成功", map);
    }

}
