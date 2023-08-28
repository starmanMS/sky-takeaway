package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * 获取店铺的营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus() {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(KEY))) {
            Integer status = redisTemplate.opsForValue().get(KEY);
            log.info("获取店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");
            return Result.success(status);
        } else {
            // 处理KEY不存在的情况
            log.warn("店铺状态KEY不存在");
            return Result.failure("店铺状态未设置");
        }
//        Integer status = redisTemplate.opsForValue().get(KEY);
//        log.info("获取店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");
//        return Result.success(status);
    }
}
