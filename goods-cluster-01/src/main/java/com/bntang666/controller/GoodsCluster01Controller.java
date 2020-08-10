package com.bntang666.controller;

import com.bntang666.util.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ：BNTang
 * @version ：V1.0
 * @program ：springcloud-netflix
 * @date ：Created in 2020/8/10 15:56
 * @description ：Goods相关的服务
 */
@RestController
public class GoodsCluster01Controller {

    @RequestMapping("/getGoods.do")
    public ResponseResult getGoods() {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "BNTangGoods-Cluster-01");
        return ResponseResult.success("获取成功", map);
    }

}