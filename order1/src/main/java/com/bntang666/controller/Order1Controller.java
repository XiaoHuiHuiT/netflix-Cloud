package com.bntang666.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Order1Controller {

    @RequestMapping("/getOrder.do")
    public Object getOrder() {
        Map<Object, Object> map = new HashMap<>();
        map.put("name", "order1Value");
        return map;
    }

}
