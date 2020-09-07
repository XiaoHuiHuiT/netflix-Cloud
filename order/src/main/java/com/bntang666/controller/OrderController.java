package com.bntang666.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/7 10:00
 * @description
 **/
@RestController
public class OrderController {

    @RequestMapping("/getOrder.do")
    public Object getOrder() {
        Map<Object, Object> map = new HashMap<>();
        map.put("name", "orderValue");
        return map;
    }

}
