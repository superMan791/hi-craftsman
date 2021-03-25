package com.cloud.br.hicraftsman.business.demo.controller;

import com.cloud.br.hicraftsman.common.core.base.R;
import com.cloud.br.hicraftsman.common.core.util.idgenerator.IdWorker;
import com.cloud.br.hicraftsman.business.demo.domain.entity.BscDictInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * redis操作
 */

@RestController
@RequestMapping("redis")
public class RedisController {
    @Resource
    private RedisTemplate<String,BscDictInfo> redisTemplate;

    @PostMapping("insert")
    public R insert(@RequestBody BscDictInfo bscDictInfo){
        Long id=IdWorker.getId();
        bscDictInfo.setId(id);
        redisTemplate.opsForValue().set(id.toString(),bscDictInfo);
        return R.ok();
    }
    @GetMapping("queryById/{id}")
    public R<BscDictInfo> queryById(@PathVariable Long id){
        return R.ok(redisTemplate.opsForValue().get(id.toString()));
    }
}
